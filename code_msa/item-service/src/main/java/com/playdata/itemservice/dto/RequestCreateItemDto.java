package com.playdata.itemservice.dto;

import com.playdata.itemservice.domain.Item;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class RequestCreateItemDto {

    //영문자, 숫자, 한글 1글자 이상이 들어오면 허용, 아닌 경우 검증 실패
    @Pattern(regexp = "^[a-zA-Z가-힣0-9]+", message="상품명은 영문, 숫자, 한글로만 구성되어야 한다.")
    @NotBlank(message = "상품명 입력 바랍니다.")
    private String productName;

    @Min(value = 0, message="재고는 음수로 들어올 수 없다.")
    @Max(value= 9999, message="재고를 9999개 이상 설정할 수 없다.")
    @NotNull
    private Long stock;

    @Min(value=0, message="가격은 음수로 들어올 수 없다.")
    @NotNull
    private Long pricePerItem;

    public Item toEntity(){
        return Item.builder()
                .productId(UUID.randomUUID().toString())
                .productName(this.productName)
                .stock(this.stock)
                .pricePerItem(this.pricePerItem)
                .build();
    }
}
