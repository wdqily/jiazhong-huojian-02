package com.jiazhong.huojian.spring.boot.rocketmq.延迟消息.消费;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 延迟消费 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_c");
        consumer.setNamesrvAddr("192.168.100.4:9876");
        consumer.subscribe("TopicC", "yanchi");
        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            list.forEach(e -> log.info("tags:{},body:{}", e.getTags(), new String(e.getBody(), StandardCharsets.UTF_8)));
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
    }
}
