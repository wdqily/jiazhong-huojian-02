package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Goods;
import com.jiazhong.huojian.spring.boot.example.shopping.handler.NowDataHandler;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.CartsMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import com.jiazhong.huojian.spring.boot.example.shopping.service.GoodsService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import com.jiazhong.huojian.spring.boot.example.shopping.util.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CartsServiceImpl extends ServiceImpl<CartsMapper, Carts> implements CartsService {
    private GoodsService goodsService;

    private StringRedisTemplate stringRedisTemplate;

    private ListOperations<String, String> forlist;

    private static final String prefix_key = "GWC_";

    @Autowired
    public CartsServiceImpl(GoodsService goodsService, StringRedisTemplate stringRedisTemplate) {
        this.goodsService = goodsService;
        this.stringRedisTemplate = stringRedisTemplate;
        forlist = stringRedisTemplate.opsForList();
    }

    @Override
    // ===== 修改开始：统一返回 JsonResult =====
    public JsonResult<List<Carts>> findCartsByUserId(String userId) {
        if (userId == null) {
            return ResultTool.fail(500, "用户id不能为空");
        }
        //1.查看redis中是否存在
        Boolean hasKey = stringRedisTemplate.hasKey(prefix_key + userId);
        //2.如果存在。返回
        if (hasKey) {
            List<String> list = forlist.range(prefix_key + userId, 0, -1);
            List<Carts> cart = new ArrayList<>();
            if (list != null) {
                for (String s : list) {
                    Carts carts = JSONArray.parseObject(s, Carts.class);
                    cart.add(carts);
                }
            }
            return ResultTool.success(cart);
        }
        //3.不存在,从数据库中拿
        QueryWrapper<Carts> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<Carts> list = list(wrapper);
        for (Carts carts : list) {
            String goodsId = carts.getGoodsId();
            Goods goods = goodsService.getById(goodsId);
            carts.setGoodsName(goods.getGoodsName());
            carts.setPrice(goods.getPrice());
        }
        //4.将数据存入redis
        for (Carts carts : list) {
            String jsonString = JSONArray.toJSONString(carts);
            forlist.rightPush(prefix_key + userId, jsonString);
        }
        return ResultTool.success(list);

    }

    @Override
    public JsonResult addCarts(Carts carts) {
        if (carts.getUserId() == null) {
            return ResultTool.fail(500, "用户id不能为空");
        }
        String userId = carts.getUserId();
        String goodsId = carts.getGoodsId();
        Integer number = carts.getNumber();
        int state = 1;
        String createTime = new NowDataHandler().getNowData();
        Goods goods = goodsService.getById(goodsId);
        String goodsName = goods.getGoodsName();
        Double price = goods.getPrice();
        carts.setPrice(price);
        carts.setCreateTime(createTime);
        carts.setState(state);
        carts.setGoodsName(goodsName);
        //判断是否存在
        int index = -1;//-1代表不存在
        List<String> range = forlist.range(prefix_key + userId, 0, -1);
        if (range == null) {
            range = new ArrayList<>();
        }
        for (int i = 0; i < range.size(); i++) {
            String s = range.get(i);
            Carts object = JSONArray.parseObject(s, Carts.class);
            if (object.getGoodsId().equals(carts.getGoodsId())) {
                index = i;
                break;
            }
        }
        //不存在 加入购物车
        if (index == -1) {
            forlist.rightPush(prefix_key + userId, JSONArray.toJSONString(carts));
            return ResultTool.success("success");
        }
        //存在 更改数量
        String s = range.get(index);
        Carts oldCart = JSONArray.parseObject(s, Carts.class);
        carts.setNumber(oldCart.getNumber() + 1);
        forlist.set(prefix_key + userId, index, JSONArray.toJSONString(carts));
        return ResultTool.success("success");
    }

    @Override
    public JsonResult deleteCartsByUserId(String userId) {
        if (userId == null) {
            return ResultTool.fail(500, "用户id不能为空");
        }
        stringRedisTemplate.delete(prefix_key + userId);
        return ResultTool.success("success");
    }

    @Override
    public JsonResult deleteCartsByBookId(String userId, String... goodsId) {
        if (userId == null || goodsId == null || goodsId.length == 0) {
            return ResultTool.fail(500, "参数不能为空");
        }
        List<String> range = forlist.range(prefix_key + userId, 0, -1);
        if (range == null || range.isEmpty()) {
            return ResultTool.fail(500, "购物车为空");
        }
        List<String> bookIds = Arrays.asList(goodsId);//转为集合
       /* stringRedisTemplate.delete(prefix_key + userId);
        boolean deleted = false;
        for (String s : range) {
            Carts carts = JSONArray.parseObject(s, Carts.class);
            if (bookIds.contains(carts.getGoodsId())) {
                deleted = true;
                continue;
            }
            forlist.rightPush(prefix_key + userId, s);//把不想删的加进去
        }*/
        boolean deleted = false;
        for (String s : range) {
            Carts carts = JSONArray.parseObject(s, Carts.class);
            if (bookIds.contains(carts.getGoodsId())) {
                forlist.remove(prefix_key + userId, 1, s);
                deleted = true;
            }
        }
        return deleted ? ResultTool.success("success") : ResultTool.fail(500, "未找到要删除的商品");
    }

    @Override
    public JsonResult updateCartsNumber(String userId, String goodsId, Integer number) {
        if (userId == null || goodsId == null || number == null || number < 0) {
            return ResultTool.fail(500, "参数错误");
        }
        List<String> range = forlist.range(prefix_key + userId, 0, -1);
        if (range == null || range.isEmpty()) {
            return ResultTool.fail(500, "购物车为空");
        }
        for (int i = 0; i < range.size(); i++) {
            String s = range.get(i);
            Carts carts = JSONArray.parseObject(s, Carts.class);
            if (goodsId.equals(carts.getGoodsId())) {
                carts.setNumber(number);
                forlist.set(prefix_key + userId, i, JSONArray.toJSONString(carts));
                return ResultTool.success("success");
            }
        }
        return ResultTool.fail(500, "未找到要修改的商品");
    }

    @Override
    public void removeAll() {
        getBaseMapper().removeAll();
    }
}
