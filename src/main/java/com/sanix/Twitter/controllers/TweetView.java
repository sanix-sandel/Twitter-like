package com.sanix.Twitter.controllers;

import com.sanix.Twitter.Dto.*;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.services.CommentService;
import com.sanix.Twitter.services.TweetService;
import com.sanix.Twitter.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class TweetView {

    private final TweetService tweetService;
    private final CommentService commentService;
    private final UserService userService;

    public TweetView(TweetService tweetService,
                     CommentService commentService,
                     UserService userService) {
        this.tweetService = tweetService;
        this.commentService=commentService;
        this.userService=userService;
    }

    @RequestMapping("/{id}")
    public String TweetDetail(@PathVariable String id, Model model){
        Long Id =Long.valueOf(id);

        model.addAttribute("new_comment", new CommentCommand());

        model.addAttribute("tweet", tweetService.findById(Id));
        model.addAttribute("comments", commentService.CommentsByTweet(Id));
        return "tweet";

    }

    @RequestMapping("/new_tweet/saved")
    public String savedTweet(@ModelAttribute TweetCommand tweetCommand){
        TweetCreation tweetCreation=new TweetCreation();
        tweetCreation.setAuthor_username(getPrincipal());
        tweetCreation.setContent(tweetCommand.getContent());
        tweetService.createTweet(tweetCreation);
        return "redirect:/";
    }

    @RequestMapping("new_comment/{id}/saved")
    public String savedComment(@PathVariable String id, @ModelAttribute CommentCommand commentCommand){

        Long Id=Long.valueOf(id);

        CommentCreation commentCreation=new CommentCreation();
        commentCreation.setContent(commentCommand.getContent());
        commentCreation.setAuthor_username(getPrincipal());
        commentCreation.setTweet_id(Id);

        commentService.createComment(commentCreation);

        return "redirect:/{id}";
    }

    @RequestMapping("/like/{id}")
    public String likeTweet(@PathVariable String id){
        Long Id=Long.valueOf(id);

        String username=getPrincipal();
        Long user_id=userService.findByUsername(username).getId();

        TweetActionDto tweetActionDto=new TweetActionDto();
        tweetActionDto.setId(Id);
        tweetActionDto.setUser_id(user_id);

        tweetService.likeAction(tweetActionDto);

        return "redirect:/";
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
