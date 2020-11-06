package com.sanix.Twitter.api;

import com.sanix.Twitter.Dto.CommentCreation;
import com.sanix.Twitter.models.Comment;
import com.sanix.Twitter.services.CommentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Comment> home(){
        Set<Comment> comments=commentService.getComments();
        return comments;
    }

    @PostMapping("create_comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody CommentCreation commentCreation){
        commentService.createComment(commentCreation);
    }

}
