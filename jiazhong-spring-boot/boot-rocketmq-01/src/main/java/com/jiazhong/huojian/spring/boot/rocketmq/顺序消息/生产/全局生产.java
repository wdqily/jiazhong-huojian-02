package com.jiazhong.huojian.spring.boot.rocketmq.顺序消息.生产;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 全局生产 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_a");
        producer.setNamesrvAddr("192.168.100.137:9876");
        producer.start();
        for (int i = 0; i < 21; i++) {
            String body = "我是全局消息，编号为：" + i;
            String tags = "Globe";
            String topic = "TopicB";
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            producer.send(message, (MessageQueueSelector)
                    (list, message1, o) -> list.get(0), 0);
        }
        producer.shutdown();
    }
}
