package com.jiazhong.huojian.spring.boot.example.shopping.controller;

import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import com.jiazhong.huojian.spring.boot.example.shopping.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    private CartsService cartsService;
    @Resource
    private GoodsService goodsService;

    @PostMapping("/save")
    public String save(Carts carts) {

        return cartsService.saveCarts(carts);
    }

    @GetMapping("/find")
    public List<Carts> find(@RequestParam("userId") String userId) {
        return cartsService.findCarts(userId);
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("userId") String userId, @RequestParam("goodsId") String goodsId) {
        return cartsService.deleteCarts(userId, goodsId);
    }

    @PostMapping("/clear")
    public String clear(@RequestParam("userId") String userId) {
        return cartsService.clearCarts(userId);
    }

    @PostMapping("/updateNum")
    public String updateNum(@RequestParam("userId") String userId, @RequestParam("goodsId") String goodsId, @RequestParam("number") Integer number) {
        return cartsService.updateCarts(userId, goodsId, number);
    }
}