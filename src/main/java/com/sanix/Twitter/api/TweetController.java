package com.sanix.Twitter.api;

import com.sanix.Twitter.dto.TweetDto;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.services.TweetService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        return tweetService.getAll();

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
