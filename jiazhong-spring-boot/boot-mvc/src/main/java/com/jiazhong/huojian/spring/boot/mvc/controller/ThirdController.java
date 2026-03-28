package com.jiazhong.huojian.spring.boot.mvc.controller;

import com.jiazhong.huojian.spring.boot.mvc.bean.User;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@RequestMapping("/third")
@Controller
@Slf4j
public class ThirdController {
    //重点
    @RequestMapping("/a")
    public void a(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("<b>你好，中国</b>");
    }

    //了解
    @RequestMapping("/b")
    public String b() {
        log.info("aaaa");
        //跳转到另一个界面
        return "redirect:/index.html";
    }

    @RequestMapping("/c")
    public String c() {
        log.info("ttttt");
        return "index";
    }

    @RequestMapping("/d")
    @ResponseBody//告诉tomcat这个返回结果是内容不是页面路径
    public String d() {
        String str = """
                你好，我是aa
                <b>你好</b>
                """;
        return str;
    }

    @RequestMapping("/e")
    @ResponseBody
    public User e() {
        User user = new User();
        user.setId(2);
        user.setAge(11);
        user.setName("lisi");
        user.setGender('女');
        return user;
    }

}
