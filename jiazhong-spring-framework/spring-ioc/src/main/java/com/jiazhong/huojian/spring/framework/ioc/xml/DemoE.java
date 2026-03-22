package com.jiazhong.huojian.spring.framework.ioc.xml;

import lombok.Data;

// 产生对象并通过构造器方式赋值
@Data
public class DemoE {
    private String a;
    private String[] b;
    private Integer c;
    private DemoB demoB;

    public DemoE() {
//        System.out.println("调用了无参数构造器给属性赋值");
    }

    public DemoE(String a) {
//        System.out.println("调用了一个String构造器给属性赋值");
        this.a = a;
    }

    public DemoE(DemoB demoB) {
//        System.out.println("调用了一个DemoB构造器给属性赋值");
        this.demoB = demoB;
    }

    public DemoE(String[] b, Integer c) {
//        System.out.println("调用了两个构造器给属性赋值");
        this.b = b;
        this.c = c;
    }

    public DemoE(String a, String[] b, Integer c, DemoB demoB) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.demoB = demoB;
    }
}
