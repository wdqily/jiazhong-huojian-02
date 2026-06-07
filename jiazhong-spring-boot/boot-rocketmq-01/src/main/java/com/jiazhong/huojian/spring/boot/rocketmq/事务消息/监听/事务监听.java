package com.jiazhong.huojian.spring.boot.rocketmq.事务消息.监听;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

@Slf4j
public class 事务监听 implements TransactionListener {
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        String keys = message.getKeys();
        log.info("开始处理消息:{},他的key为{}", message, keys);
        return switch (keys) {
            case "Num1", "Num2" -> LocalTransactionState.ROLLBACK_MESSAGE;
            case "Num3", "Num4" -> LocalTransactionState.COMMIT_MESSAGE;
            default -> LocalTransactionState.UNKNOW;
        };
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        String keys = messageExt.getKeys();
        log.info("进行第二次确认:{}", keys);
        int num = (int) (Math.random() * 100 + 1);
        if (num % 2 == 0) {
            return LocalTransactionState.COMMIT_MESSAGE;
        }
        return LocalTransactionState.UNKNOW;
    }
}
