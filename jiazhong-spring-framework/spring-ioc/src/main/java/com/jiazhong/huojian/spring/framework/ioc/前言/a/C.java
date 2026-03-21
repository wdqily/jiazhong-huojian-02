package com.jiazhong.huojian.spring.framework.ioc.前言.a;

import com.jiazhong.huojian.spring.framework.ioc.前言.A;

public class C {
    public void c() {
        A a = new A();
        int randomNumber = a.getRandomNumber();
        System.out.println("a的地址" + a);
        System.out.println(randomNumber);
    }
}
