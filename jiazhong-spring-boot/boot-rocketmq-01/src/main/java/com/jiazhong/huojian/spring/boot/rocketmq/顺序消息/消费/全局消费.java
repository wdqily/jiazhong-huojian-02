package com.jiazhong.huojian.spring.boot.rocketmq.顺序消息.消费;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 全局消费 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_b");
        consumer.setNamesrvAddr("192.168.100.137:9876");
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.subscribe("TopicB", "Globe");
        consumer.registerMessageListener((MessageListenerOrderly) (list, consumeConcurrentlyContext) -> {
            try {
                list.forEach(e -> {
                    String topic = e.getTopic();
                    String tags = e.getTags();
                    String body = new String(e.getBody(), StandardCharsets.UTF_8);
                    log.info("topic:{},tags:{},body:{}", topic, tags, body);
                });
            } catch (Exception e) {
                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
    }
}
