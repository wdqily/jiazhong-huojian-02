package com.jiazhong.huojian.spring.boot.service;

import com.jiazhong.huojian.spring.boot.util.JsonResult;
import org.springframework.stereotype.Service;

@Service
public interface FirstService {
    JsonResult find1();

    JsonResult find2();

    JsonResult find3();

    JsonResult find4();
}
