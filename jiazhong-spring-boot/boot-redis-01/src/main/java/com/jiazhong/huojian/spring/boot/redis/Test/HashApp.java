package com.jiazhong.huojian.spring.boot.redis.Test;

import com.jiazhong.huojian.spring.boot.redis.example.哈希表;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class HashApp {
    @Resource
    private 哈希表 哈希表;

    @Test
    public void a() {
        哈希表.a();
    }

    @Test
    public void b() {
        哈希表.b();
    }

    @Test
    public void c() {
        哈希表.c();
    }

    @Test
    public void d() {
        哈希表.d();
    }
}
