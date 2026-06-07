package com.jiazhong.huojian.spring.boot.rocketmq.普通消息.生产;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 单向消息 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_a");
        // 2. 指定 Namesrv 地址
        producer.setNamesrvAddr("192.168.100.4:9876");
        // 3. 启动 producer
        producer.start();
        for (int i = 0; i < 21; i++) {
            String body = "我是单向消息，编号为：" + i;
            String tags = "Oneway";
            String topic = "TopicA";
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            producer.send(message);
        }
        producer.shutdown();
    }
}
