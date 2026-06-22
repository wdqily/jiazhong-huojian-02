package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.OrderItem;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.OrderItemMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
    @Override
    public boolean saveBatch(Collection<OrderItem> entityList) {
        return super.saveBatch(entityList);
    }
}
