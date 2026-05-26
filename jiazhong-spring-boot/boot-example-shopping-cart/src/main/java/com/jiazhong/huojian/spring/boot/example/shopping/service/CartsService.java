package com.jiazhong.huojian.spring.boot.example.shopping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartsService extends IService<Carts> {
    JsonResult<List<Carts>> findCartsByUserId(String userId);

    JsonResult addCarts(Carts carts);

    //清空
    JsonResult deleteCartsByUserId(String userID);

    //删除
    JsonResult deleteCartsByBookId(String userId, String... bookId);

    //更改数量
    JsonResult updateCartsNumber(String userId, String goodsId, Integer number);

    //清除数据库中购物车的数据
    void removeAll();
}
