package com.jiazhong.huojian.spring.framework.ioc.xml;

//慢加载和勤加载
public class DemoF {
    static {
        System.out.println("这个执行后代表该类被加载了");
    }

    public DemoF() {
        System.out.println("这个执行后代表对象产生了");
    }
}
