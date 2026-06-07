package com.jiazhong.huojian.spring.boot.rocketmq.过滤消息.生产;

import com.jiazhong.huojian.spring.boot.rocketmq.bean.Users;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 过滤生产 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_e");
        producer.setNamesrvAddr("192.168.100.4:9876");
        producer.start();
        for (int i = 0; i < 21; i++) {
            int age = (int) (Math.random() * 50 + 10);
            char gender = ((int) (Math.random() * 100 + 1)) % 2 == 0 ? '男' : '女';
            String topic = "TopicE";
            String tags = "guolv";
            Users user = new Users("ZHANGHSAN" + i, age, gender, i);
            String body = user.toString();
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            // 设置条件
            message.putUserProperty("age", age + "");
            message.putUserProperty("gender", gender + "");
            SendResult sendResult = producer.send(message);
            log.info("user:{}的消息发送成功", user);
        }
        producer.shutdown();
    }
}
