package com.sanix.Twitter.controllers;

import com.sanix.Twitter.models.User;
import com.sanix.Twitter.services.TweetService;
import com.sanix.Twitter.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Account {

    private final UserService userService;
    private final TweetService tweetService;

    public Account(UserService userService, TweetService tweetService) {
        this.userService = userService;
        this.tweetService=tweetService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/profile")
    public String tweetbyUser(Model model){
        String username=getPrincipal();

        User user=userService.findByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("tweets", tweetService.tweetsByUser(user));

        return "profile";

    }


    private String getPrincipal(){
        String userName=null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().
                getPrincipal();
        if(principal instanceof UserDetails){
            userName=((UserDetails)principal).getUsername();
        }else{
            userName=principal.toString();
        }
        return userName;
    }
}
