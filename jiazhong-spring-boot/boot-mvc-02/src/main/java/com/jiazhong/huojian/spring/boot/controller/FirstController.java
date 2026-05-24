package com.jiazhong.huojian.spring.boot.controller;

import com.jiazhong.huojian.spring.boot.service.FirstService;
import com.jiazhong.huojian.spring.boot.util.JsonResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {
    @Resource
    private FirstService firstServiceService;

    @GetMapping("/a")
    public JsonResult a() {
        return firstServiceService.find1();
    }

    @GetMapping("/b")
    public JsonResult b() {
        return firstServiceService.find2();
    }

    @GetMapping("/c")
    public JsonResult c() {
        return firstServiceService.find3();
    }

    @GetMapping("/d")
    public JsonResult d() {
        return firstServiceService.find4();
    }
}
