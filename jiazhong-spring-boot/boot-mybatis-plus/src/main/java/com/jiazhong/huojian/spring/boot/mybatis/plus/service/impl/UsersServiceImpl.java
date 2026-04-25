package com.jiazhong.huojian.spring.boot.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.mybatis.plus.been.Users;
import com.jiazhong.huojian.spring.boot.mybatis.plus.mapper.UsersMapper;
import com.jiazhong.huojian.spring.boot.mybatis.plus.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
}
