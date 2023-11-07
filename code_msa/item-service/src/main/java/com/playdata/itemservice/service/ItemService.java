package com.playdata.itemservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.dto.ResponseFeignItemDto;
import com.playdata.itemservice.dto.ResponseItemDto;
import com.playdata.itemservice.feignclient.OrderFeignClient;
import com.playdata.itemservice.repository.ItemRepository;
import com.playdata.itemservice.util.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final OrderFeignClient feignClient;
    private final Producer producer;
    private final ObjectMapper objectMapper;

    public void createItem(RequestCreateItemDto dto){
        itemRepository.save(dto.toEntity());
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public ResponseItemDto findItemById(String uuid){
        Item item = itemRepository.findByProductId(uuid);
        Optional.ofNullable(item).orElseThrow(()->{
            throw new RuntimeException("등록 되지 않은 물품 입니다.");
        });
        ResponseItemDto dto = new ResponseItemDto(item);
        return dto;
    }

    public ResponseFeignItemDto findItemOrderList(String productId){

        Item item = itemRepository.findByProductId(productId);

        if(item == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404),"등록되지 않은 물품입니다.");

        ResponseFeignItemDto dto = new ResponseFeignItemDto(item);

        dto.setOrderList(feignClient.getOrdersFeignByProductId(productId));

        return dto;

    }
    
    public void publishTestMessage(String message){
        producer.sendTestMessage(message);
    }

    public void publishCreateItemMessage(RequestCreateItemDto dto)
            throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(dto);
        producer.sendCreateItemMessage(message);
    }

}
