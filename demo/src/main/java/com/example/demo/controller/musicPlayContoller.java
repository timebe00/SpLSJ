package com.example.demo.controller;

import com.example.demo.entity.Music;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class musicPlayContoller {

    private static final Logger logger = LoggerFactory.getLogger(HtmlBoardController.class);

    @PostMapping("/html/MusicController")
    public String MusicController() {
        logger.info("MusicController()");


        return "MusicController";
    }

    @ResponseBody
    @GetMapping("/html/MusicController/test")
    public Music musicTest() {
        logger.info("musicTest()");

        Music music = new Music();

        return music;
    }

    @PostMapping("/html/MusicController/Music")
    public String Music()
    {
        logger.info("Music");

        return "Music";
    }
    @ResponseBody
    @GetMapping("/html/MusicController/titles")
    public List<Music> musicTitles()
    {
        logger.info("musicTitles");
        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return list;
    }

    @ResponseBody
    @GetMapping("/html/MusicController/artists")
    public Map<String, Music> musicArtosts()
    {
        logger.info("musicArtosts()");
        Map<String, Music> map = new HashMap<String, Music>();

        Music music1 = new Music();
        map.put("Jiha", music1);

        Music music2 = new Music();
        map.put("ABC",music2);

        return map;
    }

    @GetMapping("/html/MusicController/resptest")
    public ResponseEntity<Void> musicRespTest()
    {
        logger.info("musicRespTest()");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/html/MusicController/respstring")
    public ResponseEntity<String> musicRespString()
    {
        logger.info("musicRespString()");

        return new ResponseEntity<String>(
                "ResponseEntity : Success" ,HttpStatus.OK

        );
    }
    @GetMapping("/html/MusicController/respclass")
    public ResponseEntity<Music> musicRespClass()
    {
        logger.info("musicRespClass");

        Music music = new Music();

        return new ResponseEntity<Music>(music, HttpStatus.OK);
    }

    @GetMapping("/html/MusicController/resplist")
    public ResponseEntity<List<Music>> musicRespList()
    {
        logger.info("musicRespList");

        List<Music> list = new ArrayList<Music>();

        Music music1 = new Music();
        list.add(music1);

        Music music2 = new Music();
        list.add(music2);

        return new ResponseEntity<List<Music>>(list, HttpStatus.OK);
    }

    @GetMapping("/html/MusicController/respfile")
    public ResponseEntity<byte[]> musicImgFile() throws Exception
    {
        logger.info("musicImgFile");

        InputStream in = new FileInputStream("/home/bitai/proj/PyLSJ/test_image_2.jpg");
        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            entity = new ResponseEntity<byte[]>(
                    IOUtils.toByteArray(in),headers,HttpStatus.CREATED
            );
        }
        catch (Exception e)
        {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }
        finally {
            in.close();
        }

        return entity;
    }
}
