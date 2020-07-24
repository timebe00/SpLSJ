package com.example.demo.entity;

import java.util.Date;

public class Board {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date reg_date;

    public int getBoardNo() {
        return boardNo;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public Date getReg_date() {
        return reg_date;
    }

    //////////////


    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setReg_Date(Date reg_date) {
        this.reg_date = reg_date;
    }
}
