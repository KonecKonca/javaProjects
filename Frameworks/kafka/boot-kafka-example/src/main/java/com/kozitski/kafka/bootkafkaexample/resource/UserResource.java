package com.kozitski.kafka.bootkafkaexample.resource;

import com.kozitski.kafka.bootkafkaexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {
    private static final String TOPIC = "Kafka_Example";

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;


    @PostMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message){

        kafkaTemplate.send(TOPIC, new User("andrei", 20));

        return "Published complete successfully";
    }

}
