package com.sanix.Twitter.RestXML;
/*
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.repositories.TweetRepository;
import com.sanix.Twitter.services.TweetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RestTweetController {

    private final TweetService tweetService;

    public RestTweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @RequestMapping("/xml/tweets")
    public String getTweets(Model model){
        Set<Tweet> tweets=new HashSet<>();

        tweets.addAll(tweetService.getTweets());
        model.addAttribute("tweets", tweets);
        return "tweetsTemplate";
    }
}
*/