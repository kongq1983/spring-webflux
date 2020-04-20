package com.kq.webflux.thymeleaf;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class BussinessController {

    public static final AtomicLong ato = new AtomicLong(1);

    @ResponseBody
    @RequestMapping(value = "/schedule", produces = "text/event-stream;charset=UTF-8")
    public String schedule() {
//        return "retry:5000\ndata:" + new Date().toLocaleString() + "\n\n";

        String data = new Date().toLocaleString();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",ato.getAndIncrement());
        jsonObject.put("event","server-time");
        jsonObject.put("data",data);
        jsonObject.put("retry",5000);

        return jsonObject.toJSONString();

    }



}
