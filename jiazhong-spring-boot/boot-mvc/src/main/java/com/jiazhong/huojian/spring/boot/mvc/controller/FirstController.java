package com.jiazhong.huojian.spring.boot.mvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@Slf4j
@RequestMapping("/first_controller")
public class FirstController {
    @RequestMapping("/a")
    public void a(HttpServletResponse response) throws ServletException, IOException {
        log.info("用户请求了这个controller");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello,SpringMVC</h1>");

    }
}
