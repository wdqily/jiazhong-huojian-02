package com.jiazhong.huojian.spring.boot.rocketmq.普通消息.生产;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 异步消息 {
    @SneakyThrows
    public static void main(String[] args) {
        //1. 创建消息生产者 producer，并指定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("producer_a");
        // 2. 指定 Namesrv 地址
        producer.setNamesrvAddr("192.168.100.137:9876");
        // 3. 启动 producer
        producer.start();
        for (int i = 0; i < 21; i++) {
            String body = "我是异步消息，编号为：" + i;
            String tags = "async";
            String topic = "TopicA";
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            producer.send(message, new SendCallback() {
                //成功反馈
                public void onSuccess(SendResult sendResult) {
                    log.info("success:{}", sendResult);
                }

                //失败反馈
                public void onException(Throwable throwable) {
                    log.error("fail:{}", throwable.getMessage());
                }
            });
        }
        Thread.sleep(3000);
        producer.shutdown();
    }
}
