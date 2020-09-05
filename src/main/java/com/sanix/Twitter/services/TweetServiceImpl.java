package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.TweetCreation;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.TweetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TweetServiceImpl implements TweetService{

    private final UserService userService;

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository, UserService userService) {
        this.tweetRepository = tweetRepository;
        this.userService=userService;
    }

    @Override
    @Transactional
    public Set<Tweet> getTweets(){

        Set<Tweet> tweetSet=new HashSet<>();
        tweetRepository.findAll().iterator().forEachRemaining(tweetSet::add);
        return tweetSet;

    }

    @Override
    @Transactional
    public Tweet findById(Long l){
        Optional<Tweet> tweet=tweetRepository.findById(l);

        if(! tweet.isPresent()){
            throw new RuntimeException("Tweet not found");
        }

        return tweet.get();
    }

    @Override
    @Transactional
    public void createTweet(TweetCreation tweetCreation){
        Tweet tweet=new Tweet();
        Long author_id=tweetCreation.getAuthor_id();
        tweet.setContent(tweetCreation.getContent());
        User user=userService.findById(author_id);

        tweet.setAuthor(user);
        tweetRepository.save(tweet);
    }
}
