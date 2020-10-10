package com.sanix.Twitter.controllers;

import com.sanix.Twitter.services.TweetService;
import com.sanix.Twitter.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {
    private final TweetService tweetService;
    private final UserService userService;

    public home(TweetService tweetService, UserService userService) {
        this.tweetService = tweetService;
        this.userService=userService;
    }

    @RequestMapping({"", "/"})
    public String getIndexPage(Model model){
        model.addAttribute("tweets", tweetService.getTweets());
        model.addAttribute("users", userService.getAll());
        return "home";
    }
}
