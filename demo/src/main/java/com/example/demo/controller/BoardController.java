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
    public String postRegister(Board board, Model model) throws Exception {
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

    @GetMapping("/getModify")
    public String getModify(int boardNo, Model model) throws Exception
    {
        log.info("modify()");

        model.addAttribute(service.read(boardNo));

        return "board/modify";
    }

    @PostMapping("/postModify")
    public String postModify(Board board, Model model) throws Exception
    {
        log.info("postModify()");

        service.modify(board);

        model.addAttribute("msg", "Modify Sucess");

        return "board/success";
    }
}

//  여태까지 MySQL과 Spring을 연도아는 방식을 파악하였다.
//  그러므로 현재 예제를 토대로 유사한 연습문제를 작성해 보자!
//  1. MySQL에 table를 작성한다.
//      (Entity : ItemMaina
//        id, pw, nickname, item, price)

//  2. entity 패키지에 실제 사용할 Entity 클래스를 작성한다.
//  3. controller 패키지에 URL을 처리할  ItmeMainController를 만든다.
//  4. @Service에 대한 인터패이스와 구현체를 작성한다.
//  5. @
















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