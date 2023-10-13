package com.playdata.firstservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first-service") // gateway 서버에서 predicates에 추가한 식별 주소를 추가해줘야 한다.
public class HelloController {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello, First-Service!";
    }

    @GetMapping("header-check")
    public String headerCheck(@RequestHeader("fsreqh") String header){
        return header;
    }
}
