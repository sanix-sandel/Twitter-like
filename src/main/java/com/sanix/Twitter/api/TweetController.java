package com.sanix.Twitter.api;

import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.services.TweetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/")
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<Tweet> home(){
        return tweetService.getAll()
                .stream()
                .collect(toList());
    }
}
