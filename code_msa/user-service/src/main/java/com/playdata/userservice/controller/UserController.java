package com.playdata.userservice.controller;

import com.playdata.userservice.dto.RequestCreateUserDto;
import com.playdata.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user-service")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("health-check")
    public String healthCheck(){
        return "server is available";
    }

    /*
        @RequestBody : JSON 형태로 값을 받아올 때 사용.
     */
    @PostMapping("users")
    public ResponseEntity<String> createUser(@Valid @RequestBody RequestCreateUserDto requestCreateUserDto){
        System.out.println(requestCreateUserDto);
        return ResponseEntity.ok("회원 가입 완료!");
    }
}
