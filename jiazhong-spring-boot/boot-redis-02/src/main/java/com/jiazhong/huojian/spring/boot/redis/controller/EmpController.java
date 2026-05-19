package com.jiazhong.huojian.spring.boot.redis.controller;

import com.jiazhong.huojian.spring.boot.redis.bean.Emp;
import com.jiazhong.huojian.spring.boot.redis.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Emp")
public class EmpController {
    @Resource
    private EmpService empService;

    @GetMapping(value = "/find1", produces = "application/json;charset=utf-8")
    public List<Emp> findAll1() {
        return empService.findAll1();
    }

    @GetMapping(value = "/find_id1", produces = "application/json;charset=utf-8")
    public Emp findById(@RequestParam("id") int id) {
        return empService.findById1(id);
    }

    @GetMapping(value = "/find2", produces = "application/json;charset=utf-8")
    public List<Emp> findAll2() {
        return empService.findAll2();
    }

    @GetMapping(value = "/find_id2", produces = "application/json;charset=utf-8")
    public Emp findById2(@RequestParam("id") int id) {
        return empService.findById2(id);
    }

    @RequestMapping(value = "/delete", produces = "application/json;charset=utf-8")
    public String deleteEmpById1(@RequestParam("id") int id) {
        return empService.deleteEmpById1(id);
    }

    @RequestMapping(value = "/delete2", produces = "application/json;charset=utf-8")
    public String deleteEmpById2(@RequestParam("id") int id) {
        return empService.deleteEmpById2(id);
    }

    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    public String saveEmp(@RequestBody Emp emp) {
        return empService.saveEmp(emp);
    }

}
