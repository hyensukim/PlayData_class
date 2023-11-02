package com.playdata.itemservice.controller;

import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.dto.RequestCreateItemDto;
import com.playdata.itemservice.dto.ResponseFeignItemDto;
import com.playdata.itemservice.dto.ResponseItemDto;
import com.playdata.itemservice.service.ItemService;
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
    public ResponseEntity<String> registerItem(@RequestBody RequestCreateItemDto dto){
        itemService.createItem(dto);
        return ResponseEntity.status(201).body("아이템 등록에 성공했습니다.");
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

    @GetMapping("profile-check")
    public String profileCheck(){
        return "test : ";
//                env.getProperty("test.value") +
//                "/" +
//                "ab : " +
//                env.getProperty("ab.value");
    }
}
