package com.playdata.userservice.controller;

import com.playdata.userservice.domain.User;
import com.playdata.userservice.dto.RequestCreateUserDto;
import com.playdata.userservice.dto.ResponseFindUserDto;
import com.playdata.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user-service")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Environment env;

    @GetMapping("health-check")
    public String healthCheck(){
        return "server is available";
    }

    @GetMapping("health-check2")
    public String healthCheck2(){
        return "server is available2";
    }

    /*
        @RequestBody : JSON 형태로 값을 받아올 때 사용.
     */
    @PostMapping("users")
    public ResponseEntity<String> createUser(@Valid @RequestBody RequestCreateUserDto requestCreateUserDto){
        userService.createUser(requestCreateUserDto);
        return ResponseEntity.status(201).body("회원 가입 완료 되었습니다!");
    }

    @GetMapping("users/{uuid}")
    public ResponseEntity<ResponseFindUserDto> getUser(@PathVariable String uuid){
        ResponseFindUserDto user = userService.findUserByUuid(uuid);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/all")
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("port-check")
    public String portCheck(){
        // application.yml파일에 기입된 정보를 얻어와서 자바 자료로 만들어줌.
        // 그냥 server.port로 기입하면 실제로 대입된 값인 0으로 출력
        return env.getProperty("local.server.port")
                + "/"
                + env.getProperty("test/db.value");
    }
}
