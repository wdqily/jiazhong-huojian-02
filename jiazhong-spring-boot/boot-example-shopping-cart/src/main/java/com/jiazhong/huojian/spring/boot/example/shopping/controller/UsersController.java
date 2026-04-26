package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Users;
import com.jiazhong.huojian.spring.boot.example.shopping.service.UsersService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.Md5UtilHandler;
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
    public Users login(Users users) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", users.getUsername());
        wrapper.eq("password", Md5UtilHandler.encryptMD5(users.getPassword()));
        return usersService.getOne(wrapper);
    }
}
