package com.jiazhong.huojian.spring.boot.mybatis.plus.test;

import com.jiazhong.huojian.spring.boot.mybatis.plus.been.Users;
import com.jiazhong.huojian.spring.boot.mybatis.plus.handler.Md5UtilHandler;
import com.jiazhong.huojian.spring.boot.mybatis.plus.service.UsersService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UsersApp {
    @Resource
    private UsersService service;

    @Test
    public void add() {
        Users users = new Users();
        users.setUsername("admin2");
        users.setPassword(Md5UtilHandler.encryptMD5("20050217"));
        service.save(users);
    }
}
