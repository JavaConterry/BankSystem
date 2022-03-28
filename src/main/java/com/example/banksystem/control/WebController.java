package com.example.banksystem.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class WebController {


    @GetMapping("/")
    public String greeting(Map<String, Object> Model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> Model) {
        return "main";
    }

}
