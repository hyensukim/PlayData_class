package com.playdata.secondservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("second-service")
public class HelloController {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello, Second-Service!";
    }
}
