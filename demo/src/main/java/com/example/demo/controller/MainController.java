package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//  DemoApplication에  main()이 동작하면서 자바 코드가 동작한다.
//  아래와 같은 Annotation이 붙어있으면
//  자동으로 스프링 프렝미 웍이 URL 맵핑을 제어하는 제어유닛으로 바라보낟.
@Controller
public class MainController {
    static final Logger log = LoggerFactory.getLogger(MainController.class);

    //  최상위 디렉토리
    @GetMapping("/")
    public String index(Locale locale, Model model)
    {
        log.info("index()");

        //  현재 날자를 받아온다.
        Date date = new Date();
        //  DateFormat.getDateTimeInstance를 통해
        //  연월일 시간 정보와 지역 정볼르 출력하도록 만든다.
        //  형식 지정자
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        //  위의 정보를 문자열로 만들어야 하므로 dateFormat.format을 사용함
        //  주어진 형식대로 서식이 있는 날자 형태의 문자로 만든다.
        String formattedDate = dateFormat.format(date);
        //  최종적으로 만든 정보를 servTime 속성에 전달한다.
        model.addAttribute("servTime", formattedDate);

        //  Model - 데이터(변수 비스무리한거)
        //  View - 화면(보는건) : HTML
        //  Comtroller - RestController & Controller : URL요청에 대한 응답해주는 것



        return "index";
    }
}
