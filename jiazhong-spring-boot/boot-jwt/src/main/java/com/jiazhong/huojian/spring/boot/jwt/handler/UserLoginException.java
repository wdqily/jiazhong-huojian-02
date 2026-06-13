package com.jiazhong.huojian.spring.boot.jwt.handler;

// 这个类是一个异常处理类（我自己定义的）
public class UserLoginException extends RuntimeException {
    public UserLoginException(String error) {
        super(error);
    }
}
