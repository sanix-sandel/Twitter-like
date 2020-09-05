package com.sanix.Twitter.controllers;

import com.sanix.Twitter.services.TweetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {
    private final TweetService tweetService;

    public home(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @RequestMapping({"", "/"})
    public String getIndexPage(Model model){
        model.addAttribute("tweets", tweetService.getTweets());

        return "home";
    }
}
