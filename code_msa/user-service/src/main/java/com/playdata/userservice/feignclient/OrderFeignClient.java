package com.playdata.userservice.feignclient;

import com.playdata.userservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="ORDER-SERVICE", path="order-service")// 유레카에 등록한 서비스명
public interface OrderFeignClient {
    @GetMapping("/orders/{userId}") // 엔드포인트패턴/pathVariable
    List<Order> getOrdersFeign(@PathVariable String userId); // 요청 처리
}
