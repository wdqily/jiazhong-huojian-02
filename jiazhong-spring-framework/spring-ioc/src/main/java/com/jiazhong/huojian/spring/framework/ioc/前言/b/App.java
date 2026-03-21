package com.jiazhong.huojian.spring.framework.ioc.前言.b;

import com.jiazhong.huojian.spring.framework.ioc.前言.A;

public class App {
    public static void main(String[] args) {
        A a = new A();
        new B(a).b();
        new C(a).c();

    }
}
