package com.jiazhong.huojian.spring.boot.example.shopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Stock;
import org.springframework.stereotype.Service;

@Service
public interface StockService extends IService<Stock> {
    void updateNumberAndGoodsId(String goodsId, Integer number);
}
