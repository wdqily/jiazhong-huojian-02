package com.jiazhong.huojian.spring.boot.example.shopping.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketMQConfig {

    @Value("${rocketmq.producer.group}")
    private String producerGroup;

    @Value("${rocketmq.name-server}")
    private String nameServer;

    @Value("${rocketmq.producer.transaction_group}")
    private String transaction_group;

    @Bean("rocketMQTemplate")
    public RocketMQTemplate rocketMqTemplate() {
        RocketMQTemplate rocketMqTemplate = new RocketMQTemplate();
        DefaultMQProducer defaultMqProducer = new DefaultMQProducer();
        defaultMqProducer.setProducerGroup(producerGroup);
        defaultMqProducer.setNamesrvAddr(nameServer);
        rocketMqTemplate.setProducer(defaultMqProducer);
        return rocketMqTemplate;
    }

    // 事务消息使用这个
    @Bean("transactionRocketMQTemplate")
    public RocketMQTemplate getRocketMQTransactionTemplate() {
        RocketMQTemplate rocketMQTemplate = new RocketMQTemplate();
        TransactionMQProducer transactionMQProducer = new TransactionMQProducer();
        transactionMQProducer.setNamesrvAddr(nameServer);
        transactionMQProducer.setProducerGroup(transaction_group);
        rocketMQTemplate.setProducer(transactionMQProducer);
        return rocketMQTemplate;
    }
}
