package com.jiazhong.huojian.spring.framework.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    private static void a() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.jiazhong.huojian.spring.framework.ioc.annotation");
        DemoA a = context.getBean(DemoA.class);
        System.out.println(a);
        Object da = context.getBean("da");
        System.out.println(da);
    }

    private static void b() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.jiazhong.huojian.spring.framework.ioc.annotation");
        DemoB bean = context.getBean(DemoB.class);
        System.out.println(bean);
        Object bean1 = context.getBean("db");
        System.out.println(bean1);
    }

    private static void c() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.jiazhong.huojian.spring.framework.ioc.annotation");
        DemoC bean = context.getBean(DemoC.class);
        System.out.println(bean);

    }

    private static void d() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.jiazhong.huojian.spring.framework.ioc.annotation");
        DemoD bean = context.getBean(DemoD.class);
        System.out.println(bean);

    }


    public static void main(String[] args) {
        d();
    }
}
