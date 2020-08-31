package com.sanix.Twitter.services;

import com.sanix.Twitter.models.Comment;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.repositories.CommentRepository;
import com.sanix.Twitter.repositories.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAll(){
        return commentRepository.findAll()
                .stream()
                .collect(toList());
    }
}
