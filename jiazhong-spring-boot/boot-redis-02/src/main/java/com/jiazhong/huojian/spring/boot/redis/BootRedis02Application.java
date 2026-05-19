package com.jiazhong.huojian.spring.boot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// 开启redis的注解
@EnableCaching
@SpringBootApplication
public class BootRedis02Application {
    public static void main(String[] args) {
        SpringApplication.run(BootRedis02Application.class, args);
    }
}