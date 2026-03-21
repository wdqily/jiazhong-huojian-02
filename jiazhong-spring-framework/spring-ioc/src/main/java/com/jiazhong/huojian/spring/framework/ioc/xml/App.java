package com.jiazhong.huojian.spring.framework.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static void a() {
        //自己new
        DemoA a1 = new DemoA();
        // 通过SpringIoC产生对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IoC容器里的对象
        Object da2 = context.getBean("da2");
        System.out.println(a1);
        System.out.println(da2);
    }

    private static void b() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object db = context.getBean("db");
        System.out.println(db);
    }

    private static void c() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object dc = context.getBean("dc");
        System.out.println(dc);
    }

    private static void d() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object dd = context.getBean("dd");
        System.out.println(dd);
    }

    public static void main(String[] args) {
        d();
    }
}
