package com.example.demo.controller;

import com.example.demo.entity.RandNumMussage;
import com.example.demo.service.RandNumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RandNumContorller {
    static final Logger log = LoggerFactory.getLogger(RandNumContorller.class);

    @Autowired
    private RandNumService randNumService;

    @GetMapping("/random")
    @ResponseBody
    public ResponseEntity<RandNumMussage> getRandom() {
        log.info("It's operate!");
        RandNumMussage random = randNumService.getRandom();
        return ResponseEntity.ok(random);
    }
}
