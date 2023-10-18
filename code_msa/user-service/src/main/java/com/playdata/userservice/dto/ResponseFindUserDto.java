package com.playdata.userservice.dto;

import com.playdata.userservice.domain.Order;
import com.playdata.userservice.domain.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ResponseFindUserDto {

    private String uuid;
    private Long id;
    private String userId;
    private String email;
    private String name;

    //필요 시 구매내역을 같이 가져올 수 있도록 처리.
    private List<Order> orderList;

    public ResponseFindUserDto(User user){
        this.userId = user.getUserId();
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.uuid = user.getUuid();
    }
}
