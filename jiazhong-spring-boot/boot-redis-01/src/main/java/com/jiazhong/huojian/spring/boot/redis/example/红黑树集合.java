package com.jiazhong.huojian.spring.boot.redis.example;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class 红黑树集合 {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void a() {
        ZSetOperations<String, String> zSet = stringRedisTemplate.opsForZSet();
        zSet.add("A", "a", 11);
        zSet.add("A", "b", 22);
        zSet.add("A", "c", 33);
        zSet.add("A", "d", 44);
        zSet.addIfAbsent("A", "ff", 4.7);
        zSet.addIfAbsent("A", "cc", 4.23);
        Set<String> set = Set.of("aa", "bb", "cc", "dd", "ee", "ff");
        for (String s : set) {
            zSet.add("A", "s", Math.random() * 100);
        }
    }

    public void b() {
        ZSetOperations<String, String> zset = stringRedisTemplate.opsForZSet();
        Set<String> set1 = zset.range("A", 0, -1);
        Long size = zset.count("A", 3, 7);
        String v1 = zset.randomMember("A");
        List<String> set2 = zset.randomMembers("A", 3);
        Set<String> set3 = zset.distinctRandomMembers("A", 3);
        log.info("set1:{},set2:{},set3:{},size:{},v1:{}", set1, set2, set3, size, v1);
    }

    public void c() {
        ZSetOperations<String, String> zset = stringRedisTemplate.opsForZSet();
        Set<String> set1 = zset.difference("B", "C");
        Set<String> set2 = zset.union("B", "C");
        Set<String> set3 = zset.intersect("B", "C");
        log.info("set1:{},", set1);
        log.info("set2:{},", set2);
        log.info("set3:{},", set3);
    }
}
