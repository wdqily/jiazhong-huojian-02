package com.jiazhong.huojian.spring.boot.example.shopping;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class BootExampleShoppingCartApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootExampleShoppingCartApplication.class, args);
    }
}