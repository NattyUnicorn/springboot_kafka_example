package com.example.springboot_kafka_example;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;


@Service

//继承ApplicationRunner接口，工程启动后自动运行
public class TimerService implements ApplicationRunner {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        JSONObject message = new JSONObject();
        message.put("test","生产者发送的数据");
        kafkaProducer.sendMessage("kfk_test",message);

    }

}

