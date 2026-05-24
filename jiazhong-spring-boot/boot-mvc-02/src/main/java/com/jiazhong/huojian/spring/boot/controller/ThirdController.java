package com.jiazhong.huojian.spring.boot.controller;

import com.jiazhong.huojian.spring.boot.util.JsonResult;
import com.jiazhong.huojian.spring.boot.util.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/third")
@Slf4j
public class ThirdController {
    @GetMapping
    public JsonResult execute() {
        log.info("用户访问了ThirdController的execute方法");
        return ResultTool.success("success");
    }
}
