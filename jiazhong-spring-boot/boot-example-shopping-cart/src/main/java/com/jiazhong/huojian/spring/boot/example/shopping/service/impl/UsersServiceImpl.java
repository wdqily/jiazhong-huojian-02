package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Users;
import com.jiazhong.huojian.spring.boot.example.shopping.config.JwtConfig;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.UsersMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.UsersService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import com.jiazhong.huojian.spring.boot.example.shopping.util.Md5UtilHandler;
import com.jiazhong.huojian.spring.boot.example.shopping.util.ResultTool;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public JsonResult login(Users users) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", users.getUsername());
        wrapper.eq("password", Md5UtilHandler.encryptMD5(users.getPassword()));
        Users one = getOne(wrapper);
        if (one == null) {
            return ResultTool.fail(500, "账号或密码错误");
        }
        String token = JwtConfig.getJwtToken(one);
        stringRedisTemplate.opsForValue().set("token:" + one.getId(), token, 1, TimeUnit.DAYS);
        JsonResult success = ResultTool.success(token);
        one.setPassword("");
        success.setError(one);
        return success;
    }
}
