package com.sanix.Twitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TweetController {

    @GetMapping
    public String home(){
        return "home";
    }
}
