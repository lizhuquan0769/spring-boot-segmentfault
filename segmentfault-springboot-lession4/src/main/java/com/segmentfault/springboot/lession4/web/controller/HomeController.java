package com.segmentfault.springboot.lession4.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String home(HttpServletRequest request) {
        request.setAttribute("a", "bbb");
        return "index";
    }
}
