package com.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @author smallTao.liu
 * @date 2018/6/13 16:02
 * @version V1.0
 */
@Controller
public class HelloController {

    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello SpringBoot!!!";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index.html";
    }

}
