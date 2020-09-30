package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.TweetActionDto;
import com.sanix.Twitter.Dto.TweetCreation;
import com.sanix.Twitter.Dto.TweetUpdateDTO;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.TweetRepository;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TweetServiceImpl implements TweetService{

    private final UserServiceImpl userService;

    private final TweetRepository tweetRepository;

    private final UserRepository userRepository;


    public TweetServiceImpl(TweetRepository tweetRepository,
                            UserServiceImpl userService,
                            UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userService=userService;
        this.userRepository=userRepository;
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
        Optional<Tweet> tweetOptional=tweetRepository.findById(l);

        if(! tweetOptional.isPresent()){
            throw new RuntimeException("Tweet not found");
        }

        Tweet tweet=tweetOptional.get();
        return tweet;
    }

    @Override
    @Transactional
    public void createTweet(TweetCreation tweetCreation){
        Tweet tweet=new Tweet();
        String author_username=tweetCreation.getAuthor_username();
        tweet.setContent(tweetCreation.getContent());
        User user=userService.findByUsername(author_username);
        tweet.setAuthor(user);
        //user.getTweets().add(tweet);
        tweetRepository.save(tweet);
    }

    @Override
    @Transactional
    public void likeAction(TweetActionDto tweetActionDto){
        Optional<Tweet> Optionaltweet=tweetRepository.findById(tweetActionDto.getId());
        User user=userService.findById(tweetActionDto.getUser_id());

        Tweet tweet=Optionaltweet.get();
        tweet.addLiker(user);
        tweetRepository.save(tweet);
        userRepository.save(user);

    }

    @Override
    @Transactional
    public void deleteTweet(Long l){
        Optional<Tweet> tweetOptional=tweetRepository.findById(l);
        if(! tweetOptional.isPresent()){
            throw new RuntimeException("Tweet not found");
        }
        Tweet tweet=tweetOptional.get();
        tweetRepository.delete(tweet);


    }

    @Override
    @Transactional
    public void updateTweet(Long l, TweetUpdateDTO tweetUpdateDTO){
        Optional <Tweet> tweetOptional=tweetRepository.findById(l);
        if(! tweetOptional.isPresent()){
            throw new RuntimeException("Tweet not found ");
        }
        Tweet tweet=tweetOptional.get();
        tweet.setContent(tweetUpdateDTO.getContent());
        tweetRepository.save(tweet);
    }
}
