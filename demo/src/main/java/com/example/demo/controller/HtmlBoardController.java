package com.example.demo.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class HtmlBoardController {
//    private static final Logger logger =
//            LoggerFactory.getLogger(HtmlBoardController.class);
//    @GetMapping(value = "/get", params = "register")
//    public String getRegister() {
//        logger.info("getRegister()");
//
//        return "register";
//    }
//
//    @GetMapping(value = "/get", params = "read")
//    public String getRead() {
//        logger.info("getRead()");
//
//        return "htmlRead";
//    }
//
//    @GetMapping("/html/register")
//    public String registerForm() {
//        logger.info("registerForm");
//
//        return "htmlRegister";
//    }
//
//    @PostMapping("/html/register")
//    public String register() {
//        logger.info("register(POST)");
//
//        return "htmlRegister";
//    }
//
//    @GetMapping("/html/modify")
//    public String modifyForm() {
//        logger.info("modifyForm()");
//
//        return "htmlModifyForm";
//    }
//
//    @PostMapping("/html/modify")
//    public String modify() {
//        logger.info("modify(POST)");
//
//        return "htmlModifyForm";
//    }
//
//    @PostMapping("/html/delete")
//    public String deleteForm() {
//        logger.info("deleteForm()");
//
//        return "htmlDeleteForm";
//    }
//
//    @GetMapping("/html/list")
//    public String listForm() {
//        logger.info("listForm()");
//
//        return "htmlListForm";
//    }
//
//    @GetMapping("/html/board/read/{boardNo}")
//    public String readForm(
//            // 모든 게시판에는 게시판 번호가 있다.
//            // PathVariable을 통해 가변 번호를 받을 수 있게 만든다.
//            @PathVariable("boardNo") int boardNo) {
//        logger.info("readForm: " + boardNo);
//
//        return "htmlRead";
//    }
//
//    @GetMapping("/regtestpage")
//    public String registerTestPage() {
//        logger.info("registerTestPage()");
//
//        return "form/registerForm";
//    }
//
//    @PostMapping("/regtest")
//    public String registerTest(String userId, String passwd) {
//        logger.info("registerTest()");
//
//        logger.info("userId = " + userId);
//        logger.info("passwd = " + passwd);
//
//        return "form/success";
//    }
//}

















import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class HtmlBoardController {
    private static final Logger logger = LoggerFactory.getLogger(HtmlBoardController.class);

    @GetMapping("/html/register")
    public String registerForm() {
        logger.info("registerForm");

        return "htmlRegister";
    }

    @PostMapping("/html/register")
    public String register() {
        logger.info("register(POST)");

        return "htmlRegister";
    }

    @GetMapping("/html/modify")
    public String modifyForm() {
        logger.info("modifyForm()");

        return "htmlModifyForm";
    }

    @PostMapping("/html/modify")
    public String modify() {
        logger.info("modify(POST)");

        return "htmlModifyForm";
    }

    @PostMapping("/html/delete")
    public String deleteForm() {
        logger.info("deleteForm()");

        return "htmlDeleteForm";
    }

    @GetMapping("/html/list")
    public String listForm() {
        logger.info("listForm()");

        return "htmlListForm";
    }

    @GetMapping("/html/board/read/{boardNo}")
    public ModelAndView readForm(
            // 모든 게시판에는 게시판 번호가 있다.
            // PathVariable을 통해 가변 번호를 받을 수 있게 만든다.
            @PathVariable("boardNo") int boardNo) {
        logger.info("readForm: " + boardNo);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("htmlRead");

        mav.addObject("boardNo", boardNo);

        return mav;
    }

    @GetMapping(value = "/get", params = "register")
    public String getRegister() {
        logger.info("getRegister");

        return "register";
    }

    @GetMapping(value = "/get", params = "read")
    public String getRead() {
        logger.info("getRead");

        return "htmlRead";
    }

    @GetMapping("/regtestpage")
    public String registerTestPage() {
        logger.info("registerTestPage()");

        return "form/registerForm";
    }

    @PostMapping("/regtest")
    public String registerTest(String userId, String passwd) {
        logger.info("registerTest()");

        logger.info("userId = " + userId);
        logger.info("passwd = " + passwd);

        return "form/success";
    }

    @GetMapping("/getRegTest")
    public String getRegTest(String userId, Date date)
    {
        logger.info("getRegTest");
        logger.info("userId = " + userId);
        logger.info("date = " + date);

        return "form/success";
    }
}
//
//
//
//
//    @GetMapping("/regtestpage")
//    public String registerTestPage()
//    {
//        logger.info("registerTestPage");
//
//        return "form/registerForm";
//    }
//
//    @PostMapping("/html/regtest")
//    public String registerTest(String userID, String passwd)
//    {
//        logger.info("registerTest");
//        logger.info("userID = " + userID);
//        logger.info("passwd = " + passwd);
//
//        return "form/success";
//    }
//
//    @PostMapping("/html/MusicController")
//    public String MusicController() {
//        logger.info("MusicController()");
//
//        return "MusicController";
//    }
//
//    @PostMapping("/MusicController/Music")
//    public String Music()
//    {
//        logger.info("getRead");
//
//        return "Music";
//    }
//}
