package com.playdata.userservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="users") @Builder
@Getter @AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String uuid; // 회원 상세 정보 조회 시 사용하는 필드값 -> PK를 은닉화 하기 위함.
    private String email;
    private String name;
    private String userId;
    private String encPw;
    private LocalDateTime createAt;

}
