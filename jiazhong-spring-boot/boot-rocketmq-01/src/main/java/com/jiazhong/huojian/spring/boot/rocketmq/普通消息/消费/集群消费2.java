package com.jiazhong.huojian.spring.boot.rocketmq.普通消息.消费;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 集群消费2 {
    @SneakyThrows
    public static void main(String[] args) {
        // 1. 创建消费者 Consumer，指定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_a");
        // 2. 指定 Namesrv 地址
        consumer.setNamesrvAddr("192.168.100.137:9876");
        // 3. 设置广播还是集群消费
        consumer.setMessageModel(MessageModel.CLUSTERING);
        // 4. 订阅主题 Topic 和 Tag
        consumer.subscribe("TopicA", "Oneway");
        // 5. 设置回调函数，处理消息
        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            try {
                list.forEach(e -> {
                    String topic = e.getTopic();
                    String tags = e.getTags();
                    String body = new String(e.getBody(), StandardCharsets.UTF_8);
                    log.info("topic:{},tags:{},body:{}", topic, tags, body);
                });
            } catch (Exception e) {
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        // 6. 启动消费者 Consumer
        consumer.start();
    }
}
