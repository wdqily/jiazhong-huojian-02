package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.jiazhong.huojian.spring.boot.example.shopping.bean.Goods;
import com.jiazhong.huojian.spring.boot.example.shopping.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/find")
    public List<Goods> find() {
        return goodsService.list();
    }
}
