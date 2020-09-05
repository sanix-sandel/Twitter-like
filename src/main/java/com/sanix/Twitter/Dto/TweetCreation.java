package com.sanix.Twitter.Dto;

import com.sanix.Twitter.models.User;
import com.sanix.Twitter.services.UserService;

import java.util.Optional;

public class TweetCreation {

    private final UserService userService;

    public TweetCreation(UserService userService) {
        this.userService = userService;
    }

    private String content;
    private Long author_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getAuthor_id() {
        return author_id;
    }
}
