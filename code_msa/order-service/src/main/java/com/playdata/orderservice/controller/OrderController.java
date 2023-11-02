package com.playdata.orderservice.controller;

import com.playdata.orderservice.domain.Order;
import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("orders/{userId}")
    public ResponseEntity<?> getOrdersFeignByUserId(@PathVariable String userId){
        List<Order> orders = orderService.getOrderListByUserId(userId)
                .orElseThrow(()->new RuntimeException("회원의 주문한 내역이 없습니다."));
        return ResponseEntity.ok(orders);
    }

    @GetMapping("orders/items/{productId}")
    public ResponseEntity<?> getOrdersFeignByProductId(@PathVariable String productId){
        List<Order> orders = orderService.getOrderListByProductId(productId)
                .orElseThrow(() -> new RuntimeException("주문된 상품 내역이 없습니다."));

        return ResponseEntity.status(200).body(orders);
    }
}
