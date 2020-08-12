package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class VueBoard {
    private long BoardNo;
    private String content;
    private Date regDate;
    private String title;
    private String writer;
}
