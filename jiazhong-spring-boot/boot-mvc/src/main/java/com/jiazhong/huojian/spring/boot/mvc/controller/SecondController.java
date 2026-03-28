package com.jiazhong.huojian.spring.boot.mvc.controller;

import com.jiazhong.huojian.spring.boot.mvc.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/second")
@Slf4j
public class SecondController {
    @RequestMapping(value = "/a")
    public void a() {
        log.info("SecondController`a method!");
    }

    @RequestMapping("/b")
    public void b(@RequestParam(name = "name") String name) {
        log.info("SecondController`b method!params:{}", name);
    }

    @RequestMapping("/c")
    public void c(@RequestParam("name") String name,
                  int age,
                  @RequestParam(name = "gender", defaultValue = "男") char gender) {
        log.info("SecondController`c method!name:{},age:{},gender:{}", name, age, gender);

    }

    //封装式
    @RequestMapping("/d")
    public void d(User user) {
        log.info("SecondController`d method!user:{}", user);
    }
}
