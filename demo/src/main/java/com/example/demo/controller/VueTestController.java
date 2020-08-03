package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class VueTestController {
    @GetMapping("/vuetest")
    public String vueIndex()
    {
        return "vuetest/vueIndex1";
    }
}
