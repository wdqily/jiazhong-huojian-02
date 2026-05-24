package com.jiazhong.huojian.spring.boot.controller;

import com.jiazhong.huojian.spring.boot.bean.Users;
import com.jiazhong.huojian.spring.boot.util.JsonResult;
import com.jiazhong.huojian.spring.boot.util.ResultTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/second")
public class SecondController {
    //通过？传递参数 http://localhost:8080/second/a?name=???
    @GetMapping("/a")
    public JsonResult a(@RequestParam("name") String name) {
        return ResultTool.success("success");
    }

    @GetMapping//查询是get请求
    //其他的传递参数写法 Restful
    public JsonResult find() {
        return ResultTool.success("find");
    }

    //http://localhost:8080/second/？
    @GetMapping("/{id}")
    public JsonResult findById(@PathVariable("id") int id) {
        log.info("findById:{}", id);
        return ResultTool.success("findById");
    }

    @GetMapping("/{name}/{age}")
    public JsonResult find2(@PathVariable("name") String name, @PathVariable("age") int age) {
        log.info("find2:{},{}", name, age);
        return ResultTool.success("find2");
    }

    @PostMapping//登录和添加用post
    public JsonResult save(Users users) {
        log.info("save:{}", users);
        return ResultTool.success("save");
    }

    @DeleteMapping("/{id}")
    public JsonResult remove(@PathVariable("id") int id) {
        return ResultTool.success("remove");

    }

    @PutMapping
    public JsonResult update(Users users) {
        log.info("users:{}", users);
        return ResultTool.success("update");
    }

}
