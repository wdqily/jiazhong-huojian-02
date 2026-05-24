package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Users;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.UsersMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
