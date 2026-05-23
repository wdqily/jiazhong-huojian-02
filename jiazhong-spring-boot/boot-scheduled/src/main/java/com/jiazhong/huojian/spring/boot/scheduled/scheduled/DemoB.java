package com.jiazhong.huojian.spring.boot.scheduled.scheduled;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoB {

    @Async
    @SneakyThrows
    public void b() {
        log.info("开始执行DemoB的b方法");
        Thread.sleep(10000); // 中断执行当前代码10s
        log.info("结束执行DemoB的b方法");
    }
}