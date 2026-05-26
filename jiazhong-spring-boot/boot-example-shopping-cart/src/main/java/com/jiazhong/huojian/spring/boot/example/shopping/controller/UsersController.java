package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.jiazhong.huojian.spring.boot.example.shopping.bean.Users;
import com.jiazhong.huojian.spring.boot.example.shopping.service.UsersService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult login(Users users) {
        return usersService.login(users);
    }
}
