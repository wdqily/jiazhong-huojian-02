package com.jiazhong.huojian.spring.boot.redis.example;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class 字符串 {
    // 使用SpringBoot提供的一个模版类去操作redis
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //如何存放元素
    public void a() {
        //1.获取到对string类型操作的对象
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        //2.向redis中存放元素
        forValue.set("A", "aa");
        forValue.set("B", "bb");
        forValue.set("C", "66");
        //3.存放时判断
        forValue.setIfAbsent("A", "AA1");//没有起作用
        forValue.setIfAbsent("D", "dd");
        //4.如何修改元素
        forValue.setIfPresent("B", "bb9");//起作用
        forValue.setIfPresent("E", "bb9");//不起作用
        //5.添加时设置时效
        forValue.set("F", "ff", 1, TimeUnit.MINUTES);
    }

    //如何获取元素
    public void b() {
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        String a = forValue.get("A");
        String c = forValue.get("C");
        log.info("A:{},C:{}", a, c);
    }

    //如何删除元素
    public void c() {
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        String a = forValue.getAndDelete("A");//POP
        log.info("a:{}", a);
        stringRedisTemplate.delete("B");//del
    }

    //其他方法
    public void d() {
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        Long size = forValue.size("C");
        log.info("C:{}", size);
    }


}
