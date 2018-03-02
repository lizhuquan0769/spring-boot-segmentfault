package com.segmentfault.springboot.lession4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String home(HttpServletRequest request) {
        request.setAttribute("a", "bbb");
        return "index";
    }
}
