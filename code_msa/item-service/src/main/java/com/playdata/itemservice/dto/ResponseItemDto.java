package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class ResponseItemDto {
    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;
    private String userId;
    private String orderId;

    public ResponseItemDto(Item item){
        productId = item.getProductId();
        productName = item.getProductName();
        stock = item.getStock();
        pricePerItem = item.getPricePerItem();
    }
}
