package com.kq.webflux.simple;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("index")
    public String toIndex(){
        return "index.html";
    }



}
