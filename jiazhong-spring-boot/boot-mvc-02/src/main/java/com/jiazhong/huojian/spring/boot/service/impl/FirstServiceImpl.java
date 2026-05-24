package com.jiazhong.huojian.spring.boot.service.impl;

import com.jiazhong.huojian.spring.boot.bean.Users;
import com.jiazhong.huojian.spring.boot.service.FirstService;
import com.jiazhong.huojian.spring.boot.util.JsonResult;
import com.jiazhong.huojian.spring.boot.util.ResultTool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FirstServiceImpl implements FirstService {

    @Override
    public JsonResult find1() {
        Users users = new Users();
        users.setId(111);
        users.setPassword("qqqqq");
        users.setNickname("DQ");
        users.setUsername("dq");
        /*JsonResult<Object> result = new JsonResult<>();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(users);*/
        return ResultTool.success(users);
    }

    @Override
    public JsonResult find2() {
        List<Users> list = new ArrayList<>();
        Users users = new Users(111, "ZHANGSAN", "ZAHANGSAN", "张三");
        Users users1 = new Users(222, "lisi", "ZAHANGSAN", "lisi");
        Users users2 = new Users(333, "qqq", "ZAHANGSAN", "DQ");
        list.add(users2);
        list.add(users1);
        list.add(users);
        /*JsonResult<Object> result = new JsonResult<>();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(list);*/
        return ResultTool.success(list);
    }

    @Override
    public JsonResult find3() {
        /*JsonResult<Object> result = new JsonResult<>();
        result.setCode(200);
        result.setSuccess(true);
        result.setData("成功！");*/
        return ResultTool.success("成功！");
    }

    @Override
    public JsonResult find4() {
        /*JsonResult<Object> result = new JsonResult<>();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(888);*/
        return ResultTool.success(888);
    }
}
