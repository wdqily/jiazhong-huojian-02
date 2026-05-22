package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.CartsMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import org.springframework.stereotype.Service;

@Service
public class CartsServiceImpl extends ServiceImpl<CartsMapper, Carts> implements CartsService {

}
