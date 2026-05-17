package com.jiazhong.huojian.spring.boot.redis.example;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class 无序集合 {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //添加
    public void a() {
        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        opsForSet.add("A", "aa", "bb", "cc", "11", "22");
        opsForSet.add("B", "aa", "bb", "dd", "33", "22");
        opsForSet.add("C", "aa", "bb", "ee", "44", "22");
    }

    public void b() {
        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        Set<String> ALL = opsForSet.members("A");
        String b = opsForSet.randomMember("B");
        List<String> list = opsForSet.randomMembers("C", 3);
        Set<String> set = opsForSet.distinctRandomMembers("C", 4);//不重复
        log.info("ALL:{}，b:{},list:{},set:{}", ALL, b, list, set);
    }

    public void c() {
        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        Set<String> set1 = opsForSet.difference("B", "C");
        Set<String> set2 = opsForSet.union("B", "C");
        Set<String> set3 = opsForSet.intersect("B", "C");
        log.info("set1:{},", set1);
        log.info("set2:{},", set2);
        log.info("set3:{},", set3);
    }

}
