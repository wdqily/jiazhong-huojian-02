package com.jiazhong.huojian.spring.boot.redis.Test;

import com.jiazhong.huojian.spring.boot.redis.example.无序集合;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SetApp {
    @Resource
    private 无序集合 无序集合;

    @Test
    public void a() {
        无序集合.a();
    }

    @Test
    public void b() {
        无序集合.b();
    }

    @Test
    public void c() {
        无序集合.c();
    }
}
