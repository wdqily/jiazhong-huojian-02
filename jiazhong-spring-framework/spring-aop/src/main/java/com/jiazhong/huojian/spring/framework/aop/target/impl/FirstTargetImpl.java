package com.jiazhong.huojian.spring.framework.aop.target.impl;

import com.jiazhong.huojian.spring.framework.aop.target.FirstTarget;
import org.springframework.stereotype.Component;

@Component
public class FirstTargetImpl implements FirstTarget {
    @Override
    //方法开启了事务操作
    public void delete(int id) {
        System.out.println("执行了删除操作1");
        System.out.println("执行了删除操作2");
        System.out.println("执行了删除操作3");
    }

    @Override
    public void update() {
        System.out.println("开始执行update方法");
        int i = 4 / 0;
        System.out.println("结果是" + i);
    }

    @Override
    public void add(String name) {
        System.out.println("执行了FirstTarget的add方法");
    }

    @Override
    public String find() {
        return "";
    }
}
