package com.sanix.Twitter.api;

//import com.sanix.Twitter.dto.TweetDto;
import com.sanix.Twitter.Dto.TweetCreation;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.services.TweetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/tweets/")
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Tweet> home(){
        Set<Tweet> tweets=tweetService.getTweets();
        return tweets;
    }

    @PostMapping("new_tweet")
    public void createTweet(@RequestBody TweetCreation tweetCreation){
        tweetService.createTweet(tweetCreation);
        //return new ResponseEntity<>("Tweet created successfully", OK);
    }

    /*@GetMapping("/{id}")
    public TweetDto getTweet(@PathVariable Long id){
        return tweetService.getTweet(id);
    }

    @PostMapping
    public TweetDto create(@RequestBody @Valid TweetDto tweetDto){
        return tweetService.save(tweetDto);
    }*/
}
