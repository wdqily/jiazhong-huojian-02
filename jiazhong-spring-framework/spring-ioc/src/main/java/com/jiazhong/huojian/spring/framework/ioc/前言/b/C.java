package com.jiazhong.huojian.spring.framework.ioc.前言.b;

import com.jiazhong.huojian.spring.framework.ioc.前言.A;

public class C {
    private A a;

    public C(A a) {
        this.a = a;
    }

    public void c() {
        int randomNumber = a.getRandomNumber();
        System.out.println("a的地址" + a);
        System.out.println(randomNumber);
    }
}
