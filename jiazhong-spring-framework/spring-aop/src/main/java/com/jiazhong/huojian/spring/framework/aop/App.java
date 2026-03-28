package com.jiazhong.huojian.spring.framework.aop;

import com.jiazhong.huojian.spring.framework.aop.target.FirstTarget;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.jiazhong.huojian.spring.framework.aop");
        FirstTarget firstTarget = context.getBean(FirstTarget.class);
        firstTarget.delete(3);
    }
}
