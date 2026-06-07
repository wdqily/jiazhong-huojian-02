package com.jiazhong.huojian.spring.boot.rocketmq.顺序消息.生产;

import com.jiazhong.huojian.spring.boot.rocketmq.bean.Order;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

@Slf4j
public class 部分生产 {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("producer_a");
        producer.setNamesrvAddr("192.168.100.4:9876");
        producer.start();
        for (int i = 0; i < 21; i++) {
            Order order = new Order(i, (int) (Math.random() * 4), "订单" + i);
            String body = "我是部分顺序消息，编号为：" + i + ",订单是:" + order;
            String tags = "part";
            String topic = "TopicB";
            Message message = new Message(topic, tags, body.getBytes(StandardCharsets.UTF_8));
            producer.send(message, (MessageQueueSelector)
                    (list, message1, o) -> list.get(order.getState()), order.getState());
        }
        producer.shutdown();
    }
}
