package com.jiazhong.huojian.spring.boot.redis.Test;

import com.jiazhong.huojian.spring.boot.redis.example.有序集合;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ListApp {
    @Resource
    private 有序集合 有序集合;

    @Test
    public void a() {
        有序集合.a();
    }

    @Test
    public void b() {
        有序集合.b();
    }

    @Test
    public void c() {
        有序集合.c();
    }

    @Test
    public void d() {
        有序集合.d();
    }

    @Test
    public void e() {
        有序集合.e();
    }
}
