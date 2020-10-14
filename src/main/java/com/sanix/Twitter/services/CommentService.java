package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.CommentCreation;
import com.sanix.Twitter.models.Comment;

import java.util.Set;

public interface CommentService {
    Set<Comment> getComments();
    Comment findById(Long l);
    void createComment(CommentCreation commentCreation);
    Set<Comment> CommentsByTweet(Long l);
}
