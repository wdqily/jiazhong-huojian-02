package com.jiazhong.huojian.spring.boot.redis.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.redis.bean.Emp;
import com.jiazhong.huojian.spring.boot.redis.mapper.EmpMapper;
import com.jiazhong.huojian.spring.boot.redis.service.EmpService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<Emp> findAll1() {
        log.info("开始检索所有emp信息");
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        //1.判断是否在redis中
        String allEmpData = forValue.get("ALL_EMP_DATA");
        log.info("开始获取到redis中存放的数据,{}", allEmpData);
        //1.1如果存在，直接返回
        if (allEmpData != null) {
            log.info("存在这个数据，直接返回！");
            return JSONArray.parseArray(allEmpData, Emp.class);
        }
        //1.2.1不存在，查询数据库
        List<Emp> list = list();
        log.info("不存在，从数据库中获取数据,{}", list);
        //1.2.2将数据库数据存放在redis里
        forValue.set("ALL_EMP_DATA", JSONArray.toJSONString(list));
        log.info("存放到redis中并返回数据");
        return list;
    }

    @Override
    public Emp findById1(int id) {
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        String s = forValue.get("EMP_ID" + id);
        if (s != null) {
            return JSON.parseObject(s, Emp.class);
        }
        Emp emp = getById(id);
        forValue.set("EMP_ID" + id, JSONArray.toJSONString(emp));
        return emp;
    }

    /*
    @Cacheable 是redis的查询注解，当该key在redis中存在时，直接返回数据，不执行方法，如果不存在时，执行方法并将返回的返回结果存放到redis中
     */
    @Cacheable(cacheNames = "ALL_EMP_DATA", key = "2") // ALL_EMP_DATA::2
    public List<Emp> findAll2() {
        log.info("redis中不存在数据，调用数据库");
        return list();
    }

    @Cacheable(cacheNames = "EMP_ID", key = "#id")
    public Emp findById2(int id) {
        return getById(id);
    }

    @Override
    public String deleteEmpById1(int id) {
        boolean remove = removeById(id);
        if (remove) {
            stringRedisTemplate.delete("ALL_EMP_DATA");
            stringRedisTemplate.delete("EMP_ID" + id);
            return "success";
        }
        return "error";
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = "ALL_EMP_DATA", key = "2"),
            @CacheEvict(cacheNames = "EMP_ID", key = "#id")
    }
    )
    public String deleteEmpById2(int id) {
        removeById(id);
        return "success";
    }

    @Override
    public String saveEmp(Emp emp) {
        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        boolean save = save(emp);
        if (save) {
            stringRedisTemplate.delete("SAVE_EMP");
            return "success";
        }
        return "error";
    }
}