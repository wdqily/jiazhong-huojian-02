package com.jiazhong.huojian.spring.boot.IoC.mybatis.test;

import com.jiazhong.huojian.spring.boot.IoC.mybatis.bean.Emp;
import com.jiazhong.huojian.spring.boot.IoC.mybatis.mapper.EmpMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//这是一个测试类
public class App {
    @Resource
    private EmpMapper empMapper;

    @Test
    public void a() {
        List<Emp> list = empMapper.findAll();
        list.forEach(System.out::println);
    }

    @Test
    public void b() {

    }

}
