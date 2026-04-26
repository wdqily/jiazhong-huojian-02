package com.jiazhong.huojian.spring.boot.example.crud.controller;

import com.github.pagehelper.PageInfo;
import com.jiazhong.huojian.spring.boot.example.crud.bean.Emp;
import com.jiazhong.huojian.spring.boot.example.crud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @ResponseBody//返回数据
    @RequestMapping("/find")
    public List<Emp> findAll() {
        return empService.findALL();
    }

    @ResponseBody
    @RequestMapping("/page")
    public PageInfo<Emp> findByPage(@RequestParam(name = "page", defaultValue = "1") int page) {
        return empService.findByPage(page);
    }

    @ResponseBody
    @RequestMapping("/search")
    public PageInfo<Emp> searchByName(@RequestParam(name = "page", defaultValue = "1") int page,
                                      @RequestParam("ename") String ename)//与前端一致是不用写@RequestParam
    {
        return empService.searchByName(page, ename);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public int delete(@RequestParam("id") int id) {
        return empService.delete(id);

    }

    @ResponseBody
    @PostMapping("/add")
    public int add(@RequestBody Emp emp) {
        return empService.add(emp);
    }

    @ResponseBody
    @PostMapping("/update")
    public int update(@RequestBody Emp emp) {
        return empService.update(emp);
    }

}

