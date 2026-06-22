package com.jiazhong.huojian.spring.boot.example.shopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Order;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends IService<Order> {
    JsonResult saveOrder(String nickname, String phone, String address, String token);
}
