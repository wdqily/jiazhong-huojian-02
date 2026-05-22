package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Goods;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import com.jiazhong.huojian.spring.boot.example.shopping.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    private CartsService cartsService;
    @Resource
    private GoodsService goodsService;


    @PostMapping("/save")
    public String save(Carts carts) {
        //1.判断这个商品是否在购物车里
        QueryWrapper<Carts> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", carts.getUserId());
        queryWrapper.eq("goods_id", carts.getGoodsId());
        Carts one = cartsService.getOne(queryWrapper);
        //2.如果在 继续添加时number+1
        if (one != null) {
            UpdateWrapper<Carts> wrapper = new UpdateWrapper<>();
            wrapper.set("number", one.getNumber() + 1);
            wrapper.eq("id", one.getId());
            return cartsService.update(wrapper) ? "success" : "error";
        }
        //3.不存在，加入购物车
        return cartsService.save(carts) ? "success" : "error";
    }

    @GetMapping("/find")
    public List<Carts> find(@RequestParam("userId") String userId) {
        QueryWrapper<Carts> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<Carts> list = cartsService.list(wrapper);
        for (Carts carts : list) {
            String goodsId = carts.getGoodsId();
            Goods goods = goodsService.getById(goodsId);
            carts.setGoodsName(goods.getGoodsName());
            carts.setPrice(goods.getPrice());
        }
        return list;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        return cartsService.removeById(id) ? "success" : "error";
    }

    @PostMapping("/clear")
    public String clear(@RequestParam("userId") String userId) {
        QueryWrapper<Carts> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return cartsService.remove(wrapper) ? "success" : "error";
    }

    @PostMapping("/updateNum")
    public String updateNum(String id, Integer number) {
        Carts carts = new Carts();
        carts.setId(id);
        carts.setNumber(number);
        return cartsService.updateById(carts) ? "success" : "error";


    }
}
