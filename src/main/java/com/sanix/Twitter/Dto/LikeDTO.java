package com.sanix.Twitter.Dto;

import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;

public class LikeDTO {

    private Long user_id;
    private Long tweet_id;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getTweet_id() {
        return tweet_id;
    }

    public void setTweet_id(Long tweet_id) {
        this.tweet_id = tweet_id;
    }
}
