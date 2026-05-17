package com.jiazhong.huojian.spring.boot.redis.Test;

import com.jiazhong.huojian.spring.boot.redis.example.字符串;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StringApp {
    @Resource
    private 字符串 字符串;

    @Test
    public void a() {
        字符串.a();
    }

    @Test
    public void b() {
        字符串.b();
    }

    @Test
    public void c() {
        字符串.c();
    }

    @Test
    public void d() {
        字符串.d();
    }
}
