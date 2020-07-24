package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//  RestController어떤 데이터든 제이슨으로 처리
@RestController
public class RestTestController {
    @RequestMapping("/com/example/demo/nativeinterface/test")
    public  String test()
    {
        return "Spring Test Check";
    }
}
