package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Stock;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.StockMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Override
    public void updateNumberAndGoodsId(String goodsId, Integer number) {
        getBaseMapper().updateNumberAndBookId(goodsId, number);
    }
}
