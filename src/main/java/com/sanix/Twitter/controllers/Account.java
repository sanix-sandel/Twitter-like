package com.sanix.Twitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Account {

   @GetMapping("/login")
    public String login(){
        return "login";
    }
}
