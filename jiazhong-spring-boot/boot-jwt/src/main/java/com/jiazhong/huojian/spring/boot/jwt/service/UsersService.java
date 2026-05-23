package com.jiazhong.huojian.spring.boot.jwt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.jwt.bean.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService extends IService<Users> {
    String login(Users users);

    boolean isLogin(String token);
}
