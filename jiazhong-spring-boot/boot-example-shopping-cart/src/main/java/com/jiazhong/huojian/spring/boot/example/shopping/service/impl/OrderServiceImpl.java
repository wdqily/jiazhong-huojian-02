package com.jiazhong.huojian.spring.boot.example.shopping.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Order;
import com.jiazhong.huojian.spring.boot.example.shopping.config.JwtConfig;
import com.jiazhong.huojian.spring.boot.example.shopping.mapper.OrderMapper;
import com.jiazhong.huojian.spring.boot.example.shopping.service.CartsService;
import com.jiazhong.huojian.spring.boot.example.shopping.service.OrderService;
import com.jiazhong.huojian.spring.boot.example.shopping.util.JsonResult;
import com.jiazhong.huojian.spring.boot.example.shopping.util.ResultTool;
import com.jiazhong.huojian.spring.boot.example.shopping.util.SnowFlakeGenerateIdWorker;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Resource
    private RocketMQTemplate transactionRocketMQTemplate;
    @Resource
    private CartsService cartsService;

    @Override
    public JsonResult saveOrder(String nickname, String phone, String address, String token) {
        //1.生成订单
        Order order = new Order();
        SnowFlakeGenerateIdWorker worker = new SnowFlakeGenerateIdWorker(0, 0);
        order.setId(worker.generateNextId());
        Claims claims = JwtConfig.parseJWT(token);
        Object userId = claims.get("id");
        order.setUserId(userId.toString());
        order.setNickname(nickname);
        order.setPhone(phone);
        order.setAddress(address);
        save(order);
        JsonResult<List<Carts>> cartsResult = cartsService.findCartsByUserId(userId.toString());
        if (cartsResult.getSuccess() == null || !cartsResult.getSuccess()) {
            return ResultTool.fail(500, "获取购物车失败");
        }

        JSONObject orderMessage = new JSONObject();
        orderMessage.put("order", order);
        orderMessage.put("cartList", cartsResult.getData());

        //2.发送给broker，事务提交后由库存监听器扣减库存
        String jsonString = JSONArray.toJSONString(orderMessage);
        Message<String> message = MessageBuilder.withPayload(jsonString).setHeader("KEYS", order.getId()).build();
        transactionRocketMQTemplate.sendMessageInTransaction("Order", message, jsonString);
        return ResultTool.success("success");
    }
}
