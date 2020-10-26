package com.sanix.Twitter.Dto;

public class CommentCommand {

    private Long tweet_id;
    private String content;

    public Long getTweet_id() {
        return tweet_id;
    }

    public void setTweet_id(Long tweet_id) {
        this.tweet_id = tweet_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
