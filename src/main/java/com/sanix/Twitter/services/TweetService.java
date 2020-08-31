package com.sanix.Twitter.services;

import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;


import static java.util.stream.Collectors.toList;


@Service
public class TweetService {

    private final TweetRepository tweetRepository;

    public TweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> getAll(){
        return tweetRepository.findAll()
                .stream()
                .collect(toList());
    }
}
