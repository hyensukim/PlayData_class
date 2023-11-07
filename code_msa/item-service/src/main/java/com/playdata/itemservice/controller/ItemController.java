package com.playdata.itemservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.dto.ResponseFeignItemDto;
import com.playdata.itemservice.dto.ResponseItemDto;
import com.playdata.itemservice.service.ItemService;
import com.playdata.itemservice.util.FeignException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item-service")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final Environment env;

    @GetMapping("health-check")
    public String checkHealth(){
        return "server is available!!";
    }

    @PostMapping("items")
    public ResponseEntity<String> registerItem(@Valid @RequestBody RequestCreateItemDto dto)
    throws JsonProcessingException {
        itemService.publishCreateItemMessage(dto);
//        itemService.createItem(dto);
        return ResponseEntity.status(200).body("메시지 큐에 생성 요청 적재 완료.");
    }

    @GetMapping("items/all")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> itemList = itemService.findItems();
        return ResponseEntity.status(200).body(itemList);
    }

    @GetMapping("items/{uuid}")
    public ResponseEntity<ResponseItemDto> getOne(@PathVariable String uuid){
        ResponseItemDto dto = itemService.findItemById(uuid);
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping("items/{productId}/orders")
    public ResponseEntity<?> findOrderListByProductId(@PathVariable String productId){
        ResponseFeignItemDto item = itemService.findItemOrderList(productId);
        return ResponseEntity.status(200).body(item);
    }

    /*
        PathVariable 이용해서 message를 큐에 적재할 수 있도록 엔드포인트 직접 설정.
     */
    @GetMapping("items/{message}/message")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        itemService.publishTestMessage(message);
        return ResponseEntity.ok("메시지 전송 성공!");
    }


    @GetMapping("profile-check")
    public String profileCheck(){
        return "test : ";
//                env.getProperty("test.value") +
//                "/" +
//                "ab : " +
//                env.getProperty("ab.value");
    }
}
