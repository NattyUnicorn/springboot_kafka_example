package com.example.springboot_kafka_example;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**

 * kafka消费者

 */

@Component
public class KafkaConsumer {

    private static final Logger LOGGER=LoggerFactory.getLogger("kafkaConsumer.class");

    @KafkaListener(topics = {"kfk_test"})
    public  void receiveDeviceData(JSONObject message){

        LOGGER.info("接收kafka中的信息："+message);


    }





}

