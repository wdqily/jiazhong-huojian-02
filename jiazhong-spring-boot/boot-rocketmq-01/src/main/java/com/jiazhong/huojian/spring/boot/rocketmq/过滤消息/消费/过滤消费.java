package com.jiazhong.huojian.spring.boot.rocketmq.过滤消息.消费;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 过滤消费 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_e");
        consumer.setNamesrvAddr("110.42.213.132:9876");
        consumer.subscribe("TopicE", MessageSelector.bySql("age>40 and gender='女'"));
        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            list.forEach(e -> log.info("tags:{},body:{}", e.getTags(), new String(e.getBody(), StandardCharsets.UTF_8)));
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
    }
}
