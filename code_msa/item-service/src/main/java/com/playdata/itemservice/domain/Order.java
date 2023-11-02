package com.playdata.itemservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
public class Order {
    private Long id;

    private String orderId;

    private Long count;

    private LocalDateTime createdAt;

    private String userId;

    private String productId;
}
