package com.test.jstest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class JSTestController {

    @GetMapping("datas")
    public ResponseEntity<List<Data>> getJsonData(){
        List<Data> data = new ArrayList<>();
        Data data1 = new Data("제품명1",1000,"삼양");
        Data data2 = new Data("제품명2",1100,"농심");
        Data data3 = new Data("제품명3",800,"롯데제과");

        data.add(data1);
        data.add(data2);
        data.add(data3);

        return ResponseEntity.status(200).body(data);
    }
}
