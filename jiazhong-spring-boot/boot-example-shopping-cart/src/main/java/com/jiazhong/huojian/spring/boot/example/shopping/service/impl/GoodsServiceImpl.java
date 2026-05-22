package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Goods;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.GoodsMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
