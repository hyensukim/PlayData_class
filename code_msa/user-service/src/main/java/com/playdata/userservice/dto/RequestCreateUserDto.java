package com.playdata.userservice.dto;

import com.playdata.userservice.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

// DTO :  엔티티를 캡슐화하기 위해 사용하는 클래스
// 회원 가입에 필요한 데이터를 가져오는 객체
/*
    @ToString 사용 시, 순환참조 방지를 위해 exclude 하여 해당 필드는 무시하도록 해준다.
    
    Bean Validation 사용 -> 입력값 유효성 검증
 */
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @Builder
@ToString
public class RequestCreateUserDto {

    @Email
    private String email;

    @Size(min=8, max=16, message="비밀번호를 8자 이상 16자 이하로 입력해주세요.")
    @NotBlank
    private String pw;

    @NotNull
    private String name;

    private String userId;

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .encPw(this.pw)
                .name(this.name)
                .userId(this.userId)
                .uuid(UUID.randomUUID().toString())
                .createAt(LocalDateTime.now())
                .build();
    }
}
