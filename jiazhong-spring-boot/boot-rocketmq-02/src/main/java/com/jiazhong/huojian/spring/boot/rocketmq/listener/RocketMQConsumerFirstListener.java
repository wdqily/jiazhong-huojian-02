package com.jiazhong.huojian.spring.boot.rocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "boot_consumer_group_a",
        topic = "BootA", selectorExpression = "*", messageModel = MessageModel.BROADCASTING)
public class RocketMQConsumerFirstListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("我是消费者,接收到了消息:{}", s);
    }
}
