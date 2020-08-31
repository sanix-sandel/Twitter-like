package com.sanix.Twitter.exceptions;

public class TweetNotFoundException extends RuntimeException{
    public TweetNotFoundException(String message){
        super(message);
    }
}
