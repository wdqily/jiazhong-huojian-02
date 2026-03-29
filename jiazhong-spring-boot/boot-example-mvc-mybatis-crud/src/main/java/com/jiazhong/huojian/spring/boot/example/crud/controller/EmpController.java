package com.jiazhong.huojian.spring.boot.example.crud.controller;

import com.jiazhong.huojian.spring.boot.example.crud.bean.Emp;
import com.jiazhong.huojian.spring.boot.example.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @ResponseBody//返回数据
    @RequestMapping("find")
    public List<Emp> findAll() {
        return empService.findALL();
    }
}
