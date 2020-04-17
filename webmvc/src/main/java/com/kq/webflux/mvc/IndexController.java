package com.kq.webflux.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("index")
    public String toIndex(){
        return "index";
    }


    @RequestMapping("index1")
    public String toIndex1(){
        return "forward:/static/index.html";
    }

    @RequestMapping("index2")
    public String toIndex2(){
        return "forward:/index.html";
    }



}
