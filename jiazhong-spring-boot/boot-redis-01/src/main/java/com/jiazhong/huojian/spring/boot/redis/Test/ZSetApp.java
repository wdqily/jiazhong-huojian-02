package com.jiazhong.huojian.spring.boot.redis.Test;

import com.jiazhong.huojian.spring.boot.redis.example.红黑树集合;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ZSetApp {

    @Resource
    private 红黑树集合 红黑树集合;

    @Test
    public void a() {
        红黑树集合.a();
    }

    @Test
    public void b() {
        红黑树集合.b();
    }

    @Test
    public void c() {
        红黑树集合.c();
    }
}