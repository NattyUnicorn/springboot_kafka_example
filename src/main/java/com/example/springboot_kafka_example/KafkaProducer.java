package com.example.springboot_kafka_example;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;


/**
 * kafka生产者
 */

@Component

public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger("KafkaProducer.class");

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String channel, JSONObject message) {

        ListenableFuture future = kafkaTemplate.send(channel, message);
        LOGGER.info("kafka生产者发送信息到" + channel);
        future.addCallback(new SuccessCallback() {
            @Override
            public void onSuccess(Object o) {

                LOGGER.info("发送成功，channel：" + channel + "，message：" + message);

            }

        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                LOGGER.info("发送异常：" + throwable);
            }

        });

    }

}

