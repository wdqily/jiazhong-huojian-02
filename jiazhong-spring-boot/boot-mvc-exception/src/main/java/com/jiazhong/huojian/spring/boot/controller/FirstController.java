package com.jiazhong.huojian.spring.boot.controller;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/a")
    public JsonResult a() {
        return ResultTool.success("This is FirstController a method!");
    }

    @GetMapping("/b")
    public JsonResult b() {
        int[] array = {0, 4, 2, 5, 0, 2};
        int index = (int) (Math.random() * 10);
        int result = 7 / array[index];
        return ResultTool.success("This is FirstController b method!,result:" + result);
    }
}