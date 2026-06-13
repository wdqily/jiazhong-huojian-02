package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.jiazhong.huojian.spring.boot.example.shopping.service.OrderService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/save")
    public JsonResult save(@RequestParam("nickname") String nickname,
                           @RequestParam("phone") String phone,
                           @RequestParam("address") String address,
                           @RequestHeader("token") String token) {
        return orderService.saveOrder(nickname, phone, address, token);
    }
}
