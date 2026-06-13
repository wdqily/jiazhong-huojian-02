package com.jiazhong.huojian.spring.boot.jwt.controller;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.spring.boot.jwt.bean.Users;
import com.jiazhong.huojian.spring.boot.jwt.service.UsersService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;

    @PostMapping("/login")
    public String login(Users users) {
        return usersService.login(users);
    }

    @PostMapping("/login2")
    public JsonResult login2(Users users) {
        return usersService.login2(users);
    }

    @GetMapping("/check_login")
    public boolean checkLogin(HttpServletRequest request) {
        return usersService.isLogin(request.getHeader("token"));
    }
}
