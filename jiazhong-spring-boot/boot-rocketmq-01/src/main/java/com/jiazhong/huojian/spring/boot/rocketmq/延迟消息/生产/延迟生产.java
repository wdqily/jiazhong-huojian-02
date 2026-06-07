package com.jiazhong.huojian.spring.boot.rocketmq.延迟消息.生产;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 延迟生产 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_c");
        producer.setNamesrvAddr("192.168.100.4:9876");
        producer.start();
        for (int i = 0; i < 21; i++) {
            String body = "我是延迟消息，编号为：" + i;
            String tags = "yanchi";
            String topic = "TopicC";
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            message.setDelayTimeLevel(2);
            SendResult sendResult = producer.send(message);
            log.info("sendResult:{}", sendResult);
        }
        producer.shutdown();
    }
}

