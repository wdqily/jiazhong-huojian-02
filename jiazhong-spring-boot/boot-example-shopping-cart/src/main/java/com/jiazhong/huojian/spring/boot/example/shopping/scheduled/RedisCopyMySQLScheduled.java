package com.jiazhong.huojian.spring.boot.example.shopping.scheduled;

import com.alibaba.fastjson.JSONArray;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//定时备份
@Component
public class RedisCopyMySQLScheduled {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private CartsService cartsService;

    @Scheduled(cron = "0 26 16 * * *")
    public void copy() {
        ListOperations<String, String> forList = stringRedisTemplate.opsForList();
        //1.获取所有购物车的key
        Set<String> keys = stringRedisTemplate.keys("GWC_*");
        //2.清除数据库中购物车数据
        cartsService.removeAll();
        //3.获取到redis里的数据
        for (String key : keys) {
            //用户的购物车信息
            List<String> range = forList.range(key, 0, -1);
            List<Carts> list = new ArrayList<>();
            for (String s : range) {
                Carts carts = JSONArray.parseObject(s, Carts.class);
                list.add(carts);
            }
            cartsService.saveBatch(list);
        }

    }
}
