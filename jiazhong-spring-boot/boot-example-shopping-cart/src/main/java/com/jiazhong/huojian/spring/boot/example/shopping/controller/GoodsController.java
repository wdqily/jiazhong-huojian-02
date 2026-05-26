package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.jiazhong.huojian.spring.boot.example.shopping.service.GoodsService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import com.jiazhong.huojian.spring.boot.example.shopping.util.ResultTool;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/find")
//    public List<Goods> find() {
//        return goodsService.list();
//    }
    public JsonResult find() {
        return ResultTool.success(goodsService.list());
    }
}
