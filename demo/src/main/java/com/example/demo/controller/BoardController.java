package com.example.demo.controller;

/*
import entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.BoardService;
*/


import com.example.demo.entity.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.service.BoardService;


@Controller
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("/getRegister")
    public String getRegister(Board board, Model model) throws Exception {
        log.info("getRegister()");

        return "board/register";
    }

    @PostMapping("/postRegister")
    public String postRegister(Board board, Model model)
            throws Exception {
        log.info("postRegister()");

        service.register(board);

        model.addAttribute(
                "msg",
                "Register Success");

        return "board/success";
    }
    //  URL 맵핑
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list()");

        //  속성추가(이름: List)일
        //  Controller -> Service -> Repository 방식으로
        //  동작하게 설계되어 있다.
        model.addAttribute(
                "list",
                service.list());
        //  HTML 파
        return "board/list";
    }

    @GetMapping("/read")
    public String read(int boardNo, Model model) throws Exception
    {
        log.info("read()");

        model.addAttribute(service.read(boardNo));

        return "board/read";
    }

    @PostMapping("/remove")
    public String remove(int boardNo, Model model) throws Exception
    {
        log.info("remove");

        service.remove(boardNo);
        model.addAttribute("msg","Success Delete!");

        return "board/success";
    }
}

















/*
@Controller
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("/getRegister")
    public void getRegister(Board board, Model model)
            throws Exception {
        log.info("getRegister()");
    }

    @PostMapping("/postRegister")
    public String postRegister(Board board, Model model)
            throws Exception {
        log.info("postRegister()");

        service.register(board);

        model.addAttribute(
                "msg",
                "Register Success");

        return "board/success";
    }

    @GetMapping("/list")
    public void list(Model model) throws Exception {
        log.info("list()");

        model.addAttribute(
                "list",
                service.list());
    }
}
*/