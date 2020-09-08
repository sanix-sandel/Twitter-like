package com.sanix.Twitter.Dto;

import com.sanix.Twitter.models.User;
import com.sanix.Twitter.services.UserService;

import java.util.Optional;

public class TweetCreation {


    private String content;
    private String author_username;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor_username() {
        return author_username;
    }

    public void setAuthor_username(String author_username) {
        this.author_username = author_username;
    }
}
