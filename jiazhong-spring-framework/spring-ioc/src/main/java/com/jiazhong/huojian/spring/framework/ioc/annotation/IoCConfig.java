package com.jiazhong.huojian.spring.framework.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类
@Configuration

public class IoCConfig {
    //我自己产生这个对象并存放在IoC容器中 默认名称是方法名，也也已自己指定
    @Bean("db")
    public DemoB demoB() {
        //自己new了这个对象
        return new DemoB();
    }
}
