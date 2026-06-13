package com.jiazhong.huojian.spring.boot.example.shopping.listen;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Carts;
import com.jiazhong.huojian.spring.boot.example.shopping.bean.Stock;
import com.jiazhong.huojian.spring.boot.example.shopping.service.StockService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

import java.util.List;

@Slf4j
@RocketMQTransactionListener(rocketMQTemplateBeanName = "transactionRocketMQTemplate")
public class TransactionOrderListener implements RocketMQLocalTransactionListener {
    @Resource
    private StockService stockService;


    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        //校验库存是否充足
        JSONObject orderMessage = JSONArray.parseObject(o.toString());
        List<Carts> list = orderMessage.getJSONArray("cartList").toJavaList(Carts.class);
        boolean flag = true;
        for (Carts carts : list) {
            String goodsId = carts.getGoodsId();
            Integer number = carts.getNumber();
            QueryWrapper<Stock> stockQueryWrapper = new QueryWrapper<>();
            stockQueryWrapper.eq("goods_id", goodsId);
            stockQueryWrapper.lt("number", number);
            List<Stock> list1 = stockService.list(stockQueryWrapper);
            log.info("数量为:{}", list1.size());
            if (!list1.isEmpty()) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        return null;
    }
}
