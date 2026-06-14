package com.jiazhong.huojian.spring.boot.cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        //1. 添加 CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放⾏哪些原始域
        config.addAllowedOrigin("*");
        //放⾏哪些请求⽅式
        config.addAllowedMethod("*");
        //放⾏哪些原始请求头部信息
        config.addAllowedHeader("*");
        // 添加最⼤存活时间 单位:秒
        config.setMaxAge(1800L);
        //2. 添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new
                UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        //3. 返回新的CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }
}
