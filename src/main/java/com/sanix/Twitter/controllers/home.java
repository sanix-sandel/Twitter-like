package com.sanix.Twitter.controllers;

import com.sanix.Twitter.models.User;
import com.sanix.Twitter.services.AuthService;
import com.sanix.Twitter.services.TweetService;
import com.sanix.Twitter.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class home {
    private final TweetService tweetService;
    private final UserService userService;
    private final AuthService authService;

    public home(TweetService tweetService, UserService userService, AuthService authService) {
        this.tweetService = tweetService;
        this.userService=userService;
        this.authService=authService;
    }

    @RequestMapping({"", "/"})
    public String getIndexPage(Model model){
        model.addAttribute("current_user", getUser());
        model.addAttribute("tweets", tweetService.getTweets());
        model.addAttribute("users", userService.usersToFollow(getUser()));
        return "home";
    }

    @RequestMapping("/guide")
    public String getGuidePage(){

        return "guide";
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

    private User getUser(){
        String username=getPrincipal();
        User user=userService.findByUsername(username);
        return user;
    }
}
