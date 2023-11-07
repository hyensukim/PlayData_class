package com.playdata.itemservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final ObjectMapper objectMapper;
    private final ItemService itemService;

    @RabbitListener(queues = "ITEM_CREATE_QUEUE")
    public void consumeMessageTest(String message)
            throws JsonProcessingException {

        // objectMapper.readValue
        RequestCreateItemDto dto =
                objectMapper.readValue(message, RequestCreateItemDto.class);
        itemService.createItem(dto);
    }
}
