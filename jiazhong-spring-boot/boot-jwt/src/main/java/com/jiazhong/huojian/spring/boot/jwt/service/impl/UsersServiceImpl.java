package com.jiazhong.huojian.spring.boot.jwt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.jwt.bean.Users;
import com.jiazhong.huojian.spring.boot.jwt.config.JwtConfig;
import com.jiazhong.huojian.spring.boot.jwt.mapper.UsersMapper;
import com.jiazhong.huojian.spring.boot.jwt.service.UsersService;
import com.jiazhong.huojian.spring.boot.jwt.util.Md5UtilHandler;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String login(Users users) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", users.getUsername());
        wrapper.eq("password", Md5UtilHandler.encryptMD5(users.getPassword()));
        Users one = getOne(wrapper);
        //1.判断用户登录是否成功
        if (one == null) {
            //2,如果失败，返回error
            return "error";
        }
        //3.如果成功，将对象转换成jwt字符串
        String token = JwtConfig.getJwtToken(one);
        //4.保存在redis中
        stringRedisTemplate.opsForValue().set("tokrn:" + one.getId(), token);
        //5.返回
        return token;
    }

    @Override
    public boolean isLogin(String token) {
        boolean b = JwtConfig.checkToken(token);
        if (!b) {
            return false;
        }
        // 跟redis中保存的token进行比对
        Claims claims = JwtConfig.parseJWT(token);
        Object id = claims.get("id");
        String redisToken = stringRedisTemplate.opsForValue().get("token:" + id);
        return token.equals(redisToken);
    }
}
