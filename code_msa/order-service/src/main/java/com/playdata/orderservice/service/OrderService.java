package com.playdata.orderservice.service;

import com.playdata.orderservice.dto.RequestCreateOrderDto;
import com.playdata.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void createOrder(RequestCreateOrderDto dto){
        orderRepository.save(dto.toEntity());
    }
}
