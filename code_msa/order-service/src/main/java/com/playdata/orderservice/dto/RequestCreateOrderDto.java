package com.playdata.orderservice.dto;

import com.playdata.orderservice.domain.Order;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @Builder
public class RequestCreateOrderDto {

    private String orderId;
    private Long count;
    private LocalDateTime createdAt;

    String userId;
    String productId;

    public Order toEntity(){
        return Order.builder()
                .count(this.count)
                .orderId(UUID.randomUUID().toString())
                .userId(this.userId)
                .productId(this.productId)
                .build();
    }
}
