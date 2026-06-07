package com.jiazhong.huojian.spring.boot.rocketmq.事务消息.生产;

import com.jiazhong.huojian.spring.boot.rocketmq.事务消息.监听.事务监听;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 事务生产 {
    @SneakyThrows
    public static void main(String[] args) {
        TransactionMQProducer producer = new TransactionMQProducer("transaction_producer_a");
        producer.setNamesrvAddr("192.168.100.137:9876");
        //设置监听器
        producer.setTransactionListener(new 事务监听());
        producer.start();
        for (int i = 0; i < 11; i++) {
            String body = "我是事务消息" + i;
            String tags = "transaction";
            String topic = "TopicA";
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            message.setKeys("Num" + i);
            TransactionSendResult sendResult = producer.sendMessageInTransaction(message, null);
            log.info("sendResult:{}", sendResult);
        }

    }
}
