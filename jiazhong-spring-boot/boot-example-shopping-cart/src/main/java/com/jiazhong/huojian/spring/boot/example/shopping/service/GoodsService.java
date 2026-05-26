package com.jiazhong.huojian.spring.boot.example.shopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Goods;
import org.springframework.stereotype.Service;

@Service
public interface GoodsService extends IService<Goods> {
    Goods findGoodsByGoodsId(String goodsId);
}
