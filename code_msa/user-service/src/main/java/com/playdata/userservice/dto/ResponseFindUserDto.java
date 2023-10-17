package com.playdata.userservice.dto;

import com.playdata.userservice.domain.User;
import lombok.*;

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

    public ResponseFindUserDto(User user){
        this.userId = user.getUserId();
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.uuid = user.getUuid();
    }
}
