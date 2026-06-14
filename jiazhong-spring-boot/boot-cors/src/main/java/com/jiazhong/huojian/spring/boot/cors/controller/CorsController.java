package com.jiazhong.huojian.spring.boot.cors.controller;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin
@RestController
@RequestMapping("/cors")
public class CorsController {

    @GetMapping
    public JsonResult excute() {
        return ResultTool.success("CorsController Success");
    }
}
