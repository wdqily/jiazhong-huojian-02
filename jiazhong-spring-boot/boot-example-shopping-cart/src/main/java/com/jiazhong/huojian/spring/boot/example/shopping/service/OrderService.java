package com.jiazhong.huojian.spring.boot.example.shopping.service;

import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    JsonResult saveOrder(String nickname, String phone, String address, String token);
}
