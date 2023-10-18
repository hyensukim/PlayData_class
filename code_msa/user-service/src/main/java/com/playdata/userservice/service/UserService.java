package com.playdata.userservice.service;

import com.playdata.userservice.domain.User;
import com.playdata.userservice.dto.RequestCreateUserDto;
import com.playdata.userservice.dto.ResponseFindUserDto;
import com.playdata.userservice.exception.UserNotFoundException;
import com.playdata.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

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
        return new ResponseFindUserDto(user);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }
}
