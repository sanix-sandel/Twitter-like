package com.sanix.Twitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Authentication {

    @RequestMapping("")
    public String login(){
        return "login";
    }
}
