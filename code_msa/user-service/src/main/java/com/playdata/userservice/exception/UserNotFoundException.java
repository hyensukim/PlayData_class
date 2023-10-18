package com.playdata.userservice.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("가입한 회원이 아닙니다. 회원가입 바랍니다.");
    }
}
