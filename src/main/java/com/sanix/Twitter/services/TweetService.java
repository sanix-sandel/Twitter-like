package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.TweetActionDto;
import com.sanix.Twitter.Dto.TweetCreation;
//import com.sanix.Twitter.dto.TweetDto;
import com.sanix.Twitter.Dto.TweetUpdateDTO;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;

import java.util.Set;


import static java.time.Instant.now;


public interface TweetService {

   Set<Tweet> getTweets();
   Tweet findById(Long l);
   void createTweet(TweetCreation tweetCreation);
   void likeAction(TweetActionDto tweetActionDto);
   void deleteTweet(Long l);
   void updateTweet(Long l, TweetUpdateDTO tweetUpdateDTO);
   Set<Tweet> tweetsByUser(User user);



}
