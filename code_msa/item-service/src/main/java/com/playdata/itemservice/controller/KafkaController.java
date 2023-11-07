package com.playdata.itemservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("item-service/kafka2")
@AllArgsConstructor
@Slf4j
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic myTopic1;
    private final NewTopic myTopic2;

    @GetMapping("/publish/mytopic1")
    public String publishSpringTopic1() {

        String message = "publish message to my_topic_1 " + UUID.randomUUID();

        CompletableFuture<CompletableFuture<SendResult<String,String>>> future
                = CompletableFuture.supplyAsync(() ->
                kafkaTemplate.send(myTopic1.name(), message).completable());

        future.thenAccept(result -> {
            log.info("Sent message=[" + message + "]");
        }).exceptionally(ex -> {
            log.error("Unable to send message=[" + message + "] due to: " + ex.getMessage());
            return null;
        });
        return "done";
    }

    @GetMapping("/publish/mytopic2")
    public String publish() {

        String message = "publish message to my_topic_2 " + UUID.randomUUID();

        return "done";
    }
}