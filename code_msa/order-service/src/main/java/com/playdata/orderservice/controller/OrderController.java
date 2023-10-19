package com.playdata.orderservice.controller;

import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("health-check")
    public String healthCheck(){
        return "order-service server is available";
    }

    @PostMapping("orders")
    public ResponseEntity<String> create(@RequestBody RequestCreateOrderDto requestCreateOrderDto){
        orderService.createOrder(requestCreateOrderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("주문이 완료되었습니다."); //201
    }
}
