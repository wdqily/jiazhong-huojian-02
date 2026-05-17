package com.jiazhong.huojian.spring.boot.redis.example;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class 有序集合 {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //添加
    public void a() {
        ListOperations<String, String> forList = stringRedisTemplate.opsForList();
        forList.leftPush("A", "aa");
        forList.leftPush("A", "bb");
        forList.leftPush("A", "cc");
        forList.rightPushAll("A", "11", "22", "33");
    }

    //获取
    public void b() {
        ListOperations<String, String> forList = stringRedisTemplate.opsForList();
        //所有
        List<String> range = forList.range("A", 0, -1);
        log.info("range:{}", range);
        String first = forList.getFirst("A");
        String last = forList.getLast("A");
        log.info("first:{},last:{}", first, last);
        //一个
        String a = forList.index("A", 1);
        log.info("a:{}", a);
        //多个
        List<String> range1 = forList.range("A", 1, 3);
        log.info("rage1:{}", range1);

    }

    //删除
    public void c() {
        ListOperations<String, String> forList = stringRedisTemplate.opsForList();
        Long remove = forList.remove("A", 1, "aa");
        log.info("remove:{}", remove);

    }

    //修改
    public void d() {
        ListOperations<String, String> forList = stringRedisTemplate.opsForList();
        forList.set("A", 2, "GG");

    }

    //其他
    public void e() {
        ListOperations<String, String> forList = stringRedisTemplate.opsForList();
        Long size = forList.size("A");
        Long index = forList.indexOf("A", "GG");
        log.info("size:{},index:{}", size, index);
        forList.rightPop("A");
        forList.leftPop("A");
        forList.leftPop("A", 1);


    }


}
