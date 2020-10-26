package com.sanix.Twitter.Dto;

public class CommentCommand {

    private Long tweet_id;
    private Long content;

    public Long getTweet_id() {
        return tweet_id;
    }

    public void setTweet_id(Long tweet_id) {
        this.tweet_id = tweet_id;
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }
}
