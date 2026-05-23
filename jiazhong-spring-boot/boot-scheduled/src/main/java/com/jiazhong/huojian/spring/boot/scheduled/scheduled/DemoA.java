package com.jiazhong.huojian.spring.boot.scheduled.scheduled;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoA {

    @Resource
    private DemoB db;

    // @Scheduled(fixedDelay = 2000)
    public void a() {
        log.info("这个方法会在每隔2秒执行");
    }

    @Scheduled(cron = "40 40 16 * * *")
    public void b() {
        log.info("b方法执行了");
    }

    @Scheduled(cron = "0/3 * * * * *")
    public void c() {
        log.info("开始执行c方法");
        db.b();
        log.info("结束执行c方法");
    }
}
