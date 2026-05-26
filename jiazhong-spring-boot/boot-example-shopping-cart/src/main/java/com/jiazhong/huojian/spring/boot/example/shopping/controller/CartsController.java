package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    private CartsService cartsService;


    @PostMapping("/save")
    public JsonResult save(Carts carts) {
        return cartsService.addCarts(carts);
    }

    @GetMapping("/find")
    public JsonResult<List<Carts>> find(@RequestParam("userId") String userId) {
        return cartsService.findCartsByUserId(userId);
    }

    @PostMapping("/delete")
    public JsonResult delete(@RequestParam("userId") String userId, @RequestParam("goodsId") String[] goodsId) {
        return cartsService.deleteCartsByBookId(userId, goodsId);
    }

    @PostMapping("/clear")
    public JsonResult clear(@RequestParam("userId") String userId) {
        return cartsService.deleteCartsByUserId(userId);
    }

    @PostMapping("/updateNum")
    public JsonResult updateNum(@RequestParam("userId") String userId, @RequestParam("goodsId") String goodsId, @RequestParam("number") Integer number) {
        return cartsService.updateCartsNumber(userId, goodsId, number);
    }
}
