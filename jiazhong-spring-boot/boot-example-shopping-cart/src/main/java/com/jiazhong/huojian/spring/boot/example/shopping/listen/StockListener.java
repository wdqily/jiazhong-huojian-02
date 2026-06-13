package com.jiazhong.huojian.spring.boot.example.shopping.listen;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.service.StockService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "boot_consumer_group_b", topic = "Order", selectorExpression = "*", messageModel = MessageModel.BROADCASTING)
public class StockListener implements RocketMQListener<String> {
    @Resource
    private StockService stockService;

    @Override
    public void onMessage(String s) {
        log.info("我是库存监听器:{}", s);
        JSONObject orderMessage = JSONArray.parseObject(s);
        List<Carts> list = orderMessage.getJSONArray("cartList").toJavaList(Carts.class);
        for (Carts carts : list) {
            String goodsId = carts.getGoodsId();
            Integer number = carts.getNumber();
            stockService.updateNumberAndGoodsId(goodsId, number);
        }
    }
}
