package com.playdata.userservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user-service")
@RestController
public class UserController {

    @RequestMapping(value = "health-check", method = RequestMethod.GET)
    public String healthCheck(){
        return "server is available";
    }
}
