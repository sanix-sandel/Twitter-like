package com.sanix.Twitter.api;

import com.sanix.Twitter.models.Comment;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.services.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> home(){
        return commentService.getAll()
                .stream()
                .collect(toList());
    }
}
