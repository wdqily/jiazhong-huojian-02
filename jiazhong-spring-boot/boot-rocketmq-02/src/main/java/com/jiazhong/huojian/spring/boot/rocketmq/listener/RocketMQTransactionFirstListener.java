package com.jiazhong.huojian.spring.boot.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

@Slf4j
@RocketMQTransactionListener(rocketMQTemplateBeanName = "transactionRocketMQTemplate")
public class RocketMQTransactionFirstListener implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("obj1:{}", message);
        log.info("obj2:{}", message.getHeaders());
        Object value = message.getHeaders().get("rocketmq_KEYS");
        log.info("开始校验半事务消息,keys:{}", value);
        if (value == null) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
        int num = Integer.parseInt(value.toString());
        log.info("payload:{}", message.getPayload());
        log.info("o:{}", o);
        if (num % 2 == 0) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        return null;
    }
}
