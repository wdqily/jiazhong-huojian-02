package com.jiazhong.huojian.spring.boot.mybatis.plus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 初始化 MybatisPlusInterceptor 核⼼插件
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加⾃动分⻚插件 PaginationInnerInterceptor
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 返回
        return interceptor;
    }

}
