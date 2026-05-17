package com.jiazhong.huojian.spring.boot.redis.example;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class 哈希表 {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //添加、修改
    public void a() {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        //单个
        opsForHash.put("A", "a", "aa");
        opsForHash.put("A", "b", "bb");
        opsForHash.put("A", "c", "11");
        opsForHash.put("A", "d", "dd");
        opsForHash.put("A", "a", "aa2");// 修改
        //多个
        Map map = new HashMap();
        map.put("e", "ee");
        map.put("f", "ff");
        opsForHash.putAll("A", map);
        // 存放时判断
        opsForHash.putIfAbsent("A", "b", "bb2");
        opsForHash.putIfAbsent("A", "f", "ff2");
    }

    //获取
    public void b() {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        //获取某个元素
        Object o = opsForHash.get("A", "a");
        log.info("o:{}", o);
        //获取所有key
        Set<Object> keys = opsForHash.keys("A");
        log.info("keys:{}", keys);
        //获取随机的操作
        Object randomKey = opsForHash.randomKey("A");
        List<Object> randomKeys = opsForHash.randomKeys("A", 3);
        Map.Entry<Object, Object> randomEntry = opsForHash.randomEntry("A");
        Map<Object, Object> randomEntries = opsForHash.randomEntries("A", 3);
        log.info("randomKey:{},randomKeys:{}", randomKey, randomKeys);
        log.info("randomEntry:{},randomEntries:{}", randomEntry, randomEntries);
        //获取全部
        Map<Object, Object> all = opsForHash.entries("A");
        log.info("all:{}", all);
    }

    //删除
    public void c() {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        opsForHash.delete("A", "a");
    }

    //其他方法
    public void d() {
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        Long size = opsForHash.size("A");
        log.info("size:{}", size);
        Boolean hasKey = opsForHash.hasKey("A", "a");
        log.info("hasKey:{}", hasKey);
        opsForHash.increment("A", "c", 2);
        opsForHash.increment("A", "c", -7);
    }

}
