package com.jiazhong.huojian.spring.boot.rocketmq.普通消息.生产;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 同步消息 {
    @SneakyThrows
    public static void main(String[] args) {
        //1. 创建消息生产者 producer，并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("producer_a");
        // 2. 指定 Namesrv 地址
        producer.setNamesrvAddr("192.168.100.4:9876");
        // 3. 启动 producer
        producer.start();
        // 4. 创建消息对象，指定 Topic、Tag 和消息体
        String body = "Hello,I'm RocketMQ sync Message";
        String topic = "TopicA";
        String tags = "sync";
        Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
        // 5. 发送消息
        SendResult sendResult = producer.send(message);
        log.info("消息反馈:{}", sendResult);
        // 6. 关闭生产者 producer
        producer.shutdown();

    }
}
