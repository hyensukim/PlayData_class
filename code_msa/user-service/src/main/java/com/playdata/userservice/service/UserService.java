package com.playdata.userservice.service;

import com.playdata.userservice.domain.Order;
import com.playdata.userservice.domain.User;
import com.playdata.userservice.dto.RequestCreateUserDto;
import com.playdata.userservice.dto.ResponseFindUserDto;
import com.playdata.userservice.exception.UserNotFoundException;
import com.playdata.userservice.feignclient.OrderFeignClient;
import com.playdata.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final OrderFeignClient orderFeignClient;

    public void createUser(RequestCreateUserDto userDto){
        userDto.setPw(encoder.encode(userDto.getPw()));
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    public ResponseFindUserDto findUserByUuid(String uuid){
        User user = userRepository.findUserByUuid(uuid);
        user = Optional.ofNullable(user).orElseThrow(()->{
            throw new UserNotFoundException();
        });
        ResponseFindUserDto dto = new ResponseFindUserDto(user);
        dto.setOrderList(List.of());
        return dto;
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public ResponseFindUserDto findUserOrderList(String userId){
        //1. 특정 유저 아이디 조회.
        User user = userRepository.findUserByUserId(userId);

        //2. feign client 사용하여 특정 유저의 구매목록을 가져온다.
        ResponseFindUserDto dto = new ResponseFindUserDto(user);

        //3. 세터로 합친다.
        dto.setOrderList(orderFeignClient.getOrdersFeign(userId));
        log.info("아이디 기반으로 유저 정보 얻어오기 : ", dto);
        //4. 반환
        return dto;
    }
}
