package com.jiazhong.huojian.spring.boot.seckill.controller;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.spring.boot.seckill.service.SeckillService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seckill")
public class SeckillController {
    @Resource
    private SeckillService seckillService;

    @GetMapping
    public JsonResult seckill(HttpServletRequest request) {
        return seckillService.seckill(request.getRemoteAddr());
    }
}