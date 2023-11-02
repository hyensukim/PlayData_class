package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import com.playdata.itemservice.domain.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseFeignItemDto {

    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;
    private List<Order> orderList;

    public ResponseFeignItemDto(Item item){
        productId = item.getProductId();
        productName = item.getProductName();
        stock = item.getStock();
        pricePerItem = item.getPricePerItem();
    }
}
