package com.jiazhong.huojian.spring.boot.seckill.service;

import com.jiazhong.huojian.commons.JsonResult;
import org.springframework.stereotype.Service;

@Service
public interface SeckillService {
    JsonResult seckill(String ip);
}
