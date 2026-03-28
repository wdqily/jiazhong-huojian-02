package com.jiazhong.huojian.spring.boot.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 加载一下Servlet
@ServletComponentScan("com.jiazhong.huojian.spring.boot.mvc.servlet")
@SpringBootApplication
public class BootMVCApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootMVCApplication.class, args);
    }
}
