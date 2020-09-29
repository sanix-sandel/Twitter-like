package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.TweetActionDto;
import com.sanix.Twitter.Dto.TweetCreation;
//import com.sanix.Twitter.dto.TweetDto;
import com.sanix.Twitter.models.Tweet;

import java.util.Set;


import static java.time.Instant.now;


public interface TweetService {

   Set<Tweet> getTweets();
   Tweet findById(Long l);
   void createTweet(TweetCreation tweetCreation);
   void likeAction(TweetActionDto tweetActionDto);


}
