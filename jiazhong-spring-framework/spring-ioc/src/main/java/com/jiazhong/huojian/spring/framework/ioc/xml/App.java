package com.jiazhong.huojian.spring.framework.ioc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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

    private static void e1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object de1 = context.getBean("de1");
        System.out.println(de1);
    }

    private static void e2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object de1 = context.getBean("de2");
        System.out.println(de1);
    }

    private static void e3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object de1 = context.getBean("de3");
        System.out.println(de1);
    }

    private static void e4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object de1 = context.getBean("de4");
        System.out.println(de1);
    }

    private static void e5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object de1 = context.getBean("de5");
        System.out.println(de1);
    }

    private static void f() {
        // 加载applicationContext.xml 加载IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //如果是懒加载 在第一次调用时产生
//        context.getBean("df");
    }

    private static void g() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("df");
        //如何获取到对象
        //1.按照名字获取到对象
//        Object da1 = context.getBean("da1");没有这个名称的对象会报错
        Object da2 = context.getBean("da2");//缺点：获取到的对象是Object类型 byName
        System.out.println(da2);
        //2.按照类型获取到对象
        DemoA da3 = context.getBean(DemoA.class);//缺点:如果有多个DemoA类型的对象，会报错 byType
        //3.按照类型和名称获取到对象
        DemoA da4 = context.getBean("da2", DemoA.class);
        System.out.println(da4);
    }

    private static void h() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("df");
        Object da41 = context.getBean("da4");
        Object da42 = context.getBean("da4");
        System.out.println(da41 == da42);

    }

    private static void i() {
        //从resources下开始查找
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");context.getBean("df");
        //从总项目路径开始查找 jiazhong-huojian-02
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("jiazhong-spring-framework//spring-ioc//src//main//resources//applicationContext.xml");
        context.getBean("da4");
    }

    public static void main(String[] args) {
        f();
    }
}
