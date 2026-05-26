package com.jiazhong.huojian.spring.boot.example.shopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Users;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import org.springframework.stereotype.Service;

@Service
public interface UsersService extends IService<Users> {
    JsonResult login(Users users);
}
