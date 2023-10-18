package com.playdata.itemservice.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="item")
@Getter @NoArgsConstructor
@AllArgsConstructor @Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;

}
