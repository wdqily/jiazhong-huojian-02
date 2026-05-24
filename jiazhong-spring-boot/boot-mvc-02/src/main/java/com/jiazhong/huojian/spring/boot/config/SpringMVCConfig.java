package com.jiazhong.huojian.spring.boot.config;

import com.jiazhong.huojian.spring.boot.interceptor.FirstInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    //注册拦截器
    @Resource
    private FirstInterceptor firstInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(firstInterceptor)
                //.addPathPatterns("/**");//对所有请求拦截
                .addPathPatterns("/first/**").excludePathPatterns("/first/a");//除了a
    }
}
