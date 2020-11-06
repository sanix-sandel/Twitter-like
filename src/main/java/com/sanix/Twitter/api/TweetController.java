package com.sanix.Twitter.api;


import com.sanix.Twitter.Dto.TweetActionDto;
import com.sanix.Twitter.Dto.TweetCreation;
import com.sanix.Twitter.Dto.TweetUpdateDTO;
import com.sanix.Twitter.models.Tweet;

import com.sanix.Twitter.services.TweetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    private final TweetService tweetService;

    public TweetController(TweetService tweetService){

        this.tweetService = tweetService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Set<Tweet> home(){
        Set<Tweet> tweets=tweetService.getTweets();
        return tweets;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tweet getTweet(@PathVariable("id") final Long id ){
        Tweet tweet=tweetService.findById(id);
        return tweet;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTweet(@PathVariable("id") Long id ){
        tweetService.deleteTweet(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTweet(@PathVariable("id") Long id, @RequestBody TweetUpdateDTO tweetUpdateDTO){
        tweetService.updateTweet(id, tweetUpdateDTO);
    }

    @PostMapping("new_tweet")
    @ResponseStatus(HttpStatus.OK)
    public void createTweet(@RequestBody TweetCreation tweetCreation){
        tweetService.createTweet(tweetCreation);

    }


    @PutMapping("like")
    @ResponseStatus(HttpStatus.OK)
    public void likeTweet(@RequestBody TweetActionDto tweetActionDto){
        tweetService.likeAction(tweetActionDto);
    }

}
