package com.jiazhong.huojian.spring.boot.rocketmq.controller;

import com.jiazhong.huojian.commons.JsonResult;
import com.jiazhong.huojian.commons.ResultTool;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rocket_mq")
public class RocketMQProducerController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Resource
    private RocketMQTemplate transactionRocketMQTemplate;

    //同步
    @GetMapping("/sync/{content}")
    public JsonResult sync(@PathVariable String content) {
        SendResult sendResult = rocketMQTemplate.syncSend("BootA:sync", content);
        return ResultTool.success(sendResult);
    }

    @SneakyThrows
    //异步
    @GetMapping("/async/{content}")
    public JsonResult async(@PathVariable String content) {
        final JsonResult[] result = {null};
        rocketMQTemplate.asyncSend("BootA:async", content, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                result[0] = ResultTool.success(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                result[0] = ResultTool.fail(500, throwable.getMessage());
            }
        });
        Thread.sleep(3000);
        return result[0];
    }

    @GetMapping("/oneway/{content}")
    public JsonResult oneway(@PathVariable String content) {
        rocketMQTemplate.sendOneWay("BootA:oneway", content);
        return ResultTool.success("success");
    }

    @GetMapping("/transaction/{content}")
    public JsonResult transaction(@PathVariable String content) {
        int num = (int) (Math.random() * 10 + 1);
        Message<String> message = MessageBuilder.withPayload(content)
                .setHeader("KEYS", String.valueOf(num))
                .build();
        TransactionSendResult sendResult = transactionRocketMQTemplate.sendMessageInTransaction("BootA:transaction", message, content);
        return ResultTool.success(sendResult);
    }
}
