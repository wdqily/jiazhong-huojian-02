package com.jiazhong.huojian.spring.boot.example;

import com.jiazhong.huojian.spring.boot.example.yaml.Classroom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
//这个项目的启动类
@SpringBootApplication
public class BootExampleApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootExampleApplication.class, args);
       /* First first = context.getBean(First.class);
        log.info("first:{}", first);*/
       /* Second second = context.getBean(Second.class);
        log.info("second:{}", second);*/
        Classroom classroom = context.getBean(Classroom.class);
        log.info("classroom:{}", classroom);
    }
}