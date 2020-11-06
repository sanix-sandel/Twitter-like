package com.sanix.Twitter.controllers;

import com.sanix.Twitter.Dto.ContactDTO;
import com.sanix.Twitter.Dto.TweetCommand;
import com.sanix.Twitter.Dto.TweetCreation;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.services.ContactService;
import com.sanix.Twitter.services.FollowService;
import com.sanix.Twitter.services.TweetService;
import com.sanix.Twitter.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Account {

    private final UserService userService;
    private final TweetService tweetService;
    private final FollowService followService;


    public Account(UserService userService,
                   TweetService tweetService,
                   FollowService followService
                  ) {
        this.userService = userService;
        this.tweetService=tweetService;
        this.followService=followService;

    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/profile")
    public String tweetbyUser(Model model){

        //User user=getUser();
        model.addAttribute("user", getUser());
        model.addAttribute("tweets", tweetService.tweetsByUser(getUser()));

        return "profile";

    }

    @GetMapping("/new_tweet")
    public String new_tweet(Model model){
        //User user=getUser();
        model.addAttribute("user", getUser());
        model.addAttribute("tweets", tweetService.tweetsByUser(getUser()));
        model.addAttribute("new_tweet", new TweetCommand());

        return "new_tweet";

    }

    @GetMapping
    @RequestMapping("/follow/{id}")
    public String follow(@PathVariable String id, Model model){
        ContactDTO contactDTO=new ContactDTO();
        //User user=getUser();
        contactDTO.setFollower_id(getUser().getId());
        contactDTO.setFollowed_id(Long.valueOf(id));

        followService.follow(contactDTO);

        return "redirect:/";

    }

    @PostMapping("/unfollow/{id}")
    public String unfollow(@PathVariable String id, Model model){
        ContactDTO contactDTO=new ContactDTO();
        //User user=getUser();
        contactDTO.setFollower_id(getUser().getId());
        contactDTO.setFollowed_id(Long.valueOf(id));

        followService.unfollow(contactDTO);

        return "redirect:/";
    }

    private String getPrincipal(){
        String userName=null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().
                getPrincipal();
        if(principal instanceof UserDetails){
            System.out.println(principal);
            System.out.println((UserDetails)principal);
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
