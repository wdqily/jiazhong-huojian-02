package com.jiazhong.huojian.spring.framework.aop.advice;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAdvice {
    @Pointcut("execution(* com.jiazhong.huojian.spring.framework.aop.target.*.*(..))")
    private void execute() {

    }

    //在执行FirstTarget的方法之前，要执行这个方法
    //定义了一个连接点(切入点)
    @Before("execution(* com.jiazhong.huojian.spring.framework.aop.target.*.*(..))")
    public void before() {
        System.out.println("我是前置通知");
    }

    @AfterReturning("execute()")
    public void after() {
        System.out.println("我是后置通知");
    }

    @SneakyThrows
    @Around("execute()")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("我是环绕通知1");
        Object proceed = pjp.proceed();//执行目标对象的方法
        System.out.println("我是环绕通知2");
    }

    // 类似于finally
    @After("execute()")
    public void zuizhong() {
        System.out.println("我是最终通知");
    }

    @AfterThrowing("execute()")
    public void throwing() {
        System.out.println("你的代码出现了异常情况");
    }


}
