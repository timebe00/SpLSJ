package com.example.demo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;


public class RandNumMussage {
    private final  static Logger log = LoggerFactory.getLogger(RandNumMussage.class);
    static Random random = new Random();
    private Integer randNumber;

    public RandNumMussage(){
        this.randNumber = random.nextInt(32)+3;
        log.info("RandomMessage(): " + randNumber);
    }

    public Integer getRandNumber() {
        return randNumber;
    }
}
