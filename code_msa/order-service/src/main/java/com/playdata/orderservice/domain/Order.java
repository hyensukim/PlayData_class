package com.playdata.orderservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Getter @NoArgsConstructor @AllArgsConstructor
@Builder
public class Order {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    private Long count;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    String userId;
    String productId;
}
