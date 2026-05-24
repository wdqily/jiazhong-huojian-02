package com.jiazhong.huojian.spring.boot.example.shopping.service;

import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartsService {
    String saveCarts(Carts carts);

    List<Carts> findCarts(String userId);

    String deleteCarts(String userId, String goodsId);

    String clearCarts(String userId);

    String updateCarts(String userId, String goodsId, Integer number);
}
