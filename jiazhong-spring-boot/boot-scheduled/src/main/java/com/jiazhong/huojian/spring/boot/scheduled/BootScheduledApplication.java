package com.jiazhong.huojian.spring.boot.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class BootScheduledApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootScheduledApplication.class, args);
    }
}