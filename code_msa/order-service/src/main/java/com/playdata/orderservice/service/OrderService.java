package com.playdata.orderservice.service;

import com.playdata.orderservice.domain.Order;
import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderService {
    private final OrderRepository orderRepository;

    public void createOrder(RequestCreateOrderDto dto){
        orderRepository.save(dto.toEntity());
    }

    public Optional<List<Order>> getOrderListByUserId(String userId){
        return orderRepository.findOrderByUserIdOrderByIdDesc(userId);
    }

    public Optional<List<Order>> getOrderListByProductId(String productId){
        return orderRepository.findOrderByProductIdOrderByIdDesc(productId);
    }
}
