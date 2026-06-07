package com.jiazhong.huojian.spring.boot.rocketmq.批量消息.生产;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class 批量生产 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_d");
        producer.setNamesrvAddr("192.168.100.137:9876");
        producer.start();
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            String body = "我是批量消息，编号为：" + i;
            String tags = "some";
            String topic = "TopicD";
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            list.add(message);
        }
        SendResult sendResult = producer.send(list);
        log.info("sendResult:{}", sendResult);
        producer.shutdown();
    }
}
