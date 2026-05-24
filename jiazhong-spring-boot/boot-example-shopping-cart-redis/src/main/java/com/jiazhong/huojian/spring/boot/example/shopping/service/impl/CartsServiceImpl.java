package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Goods;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.CartsMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import com.jiazhong.huojian.spring.boot.example.shopping.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartsServiceImpl extends ServiceImpl<CartsMapper, Carts> implements CartsService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private GoodsService goodsService;

    public String saveCarts(Carts carts) {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        String goodsId = carts.getGoodsId();
        String userId = carts.getUserId();
        //1.判断商品是否在购物车里
        Boolean hasKey = opsForHash.hasKey(userId, goodsId);
        if (hasKey) {
            opsForHash.increment(userId, goodsId, 1);
        } else {
            Integer number = carts.getNumber();
            opsForHash.put(userId, goodsId, String.valueOf(number));
        }
        return "success";
    }

    @Override
    public List<Carts> findCarts(String userId) {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        Map<Object, Object> entries = opsForHash.entries(userId);
        List<Carts> list = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            String goodsId = (String) (entry.getKey());//转成String
            Integer number = Integer.parseInt((String) entry.getValue());
            Carts carts = new Carts();
            carts.setGoodsId(goodsId);
            carts.setNumber(number);
            carts.setUserId(userId);
            Goods goods = goodsService.getById(goodsId);
            carts.setGoodsName(goods.getGoodsName());
            carts.setPrice(goods.getPrice());
            list.add(carts);
        }
        return list;
    }

    @Override
    public String deleteCarts(String userID, String goodsId) {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        opsForHash.delete(userID, goodsId);
        return "success";
    }

    @Override
    public String clearCarts(String userId) {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        stringRedisTemplate.delete(userId);
        return "success";
    }

    @Override
    public String updateCarts(String userId, String goodsId, Integer number) {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        opsForHash.put(userId, goodsId, String.valueOf(number));
        return "success";
    }
}
