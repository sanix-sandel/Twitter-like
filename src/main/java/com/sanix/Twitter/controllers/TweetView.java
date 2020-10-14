package com.sanix.Twitter.controllers;

import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.services.CommentService;
import com.sanix.Twitter.services.TweetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class TweetView {

    private final TweetService tweetService;
    private final CommentService commentService;

    public TweetView(TweetService tweetService,
                     CommentService commentService) {
        this.tweetService = tweetService;
        this.commentService=commentService;
    }

    @RequestMapping("/{id}")
    public String TweetDetail(@PathVariable Long id, Model model){
        model.addAttribute("tweet", tweetService.findById(id));
        model.addAttribute("comments", commentService.CommentsByTweet(id));
        return "tweet";

    }

}
