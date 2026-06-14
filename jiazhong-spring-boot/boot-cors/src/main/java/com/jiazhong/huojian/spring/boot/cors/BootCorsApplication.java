package com.jiazhong.huojian.spring.boot.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ServletComponentScan("com.jiazhong.huojian.spring.boot.cors.filter")
@SpringBootApplication
public class BootCorsApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootCorsApplication.class, args);
    }
}