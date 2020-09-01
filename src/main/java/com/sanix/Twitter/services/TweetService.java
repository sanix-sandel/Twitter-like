package com.sanix.Twitter.services;

import com.sanix.Twitter.dto.TweetDto;
import com.sanix.Twitter.exceptions.TweetNotFoundException;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.TweetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;


@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Transactional
    public List<Tweet> getAll(){

        List<Tweet> tweetList=new ArrayList<>();
        tweetRepository.findAll().iterator().forEachRemaining(tweetList::add);
        return tweetList;

    }

    /*@Transactional
    public TweetDto save(TweetDto tweetDto){
        Tweet tweet=tweetRepository.save(mapToTweet(tweetDto));
        tweetDto.setId(tweet.getId());
        return tweetDto;
    }

    public TweetDto getTweet(Long id){
        Tweet tweet=tweetRepository.findById(id)
                .orElseThrow(()->new TweetNotFoundException("No tweet found with ID "+id));
        return mapToDto(tweet);
    }

    private TweetDto mapToDto(Tweet tweet){
        return TweetDto.builder().content(tweet.getContent())
                .id(tweet.getId())
                .build();
    }

    private Tweet mapToTweet(TweetDto tweetDto){
        return Tweet.builder().content(tweetDto.getContent())
                .id(tweetDto.getId())
                .created(now())
                .build();
    }*/
}
