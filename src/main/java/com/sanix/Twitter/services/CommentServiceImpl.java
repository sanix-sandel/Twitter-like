package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.CommentCreation;
import com.sanix.Twitter.models.Comment;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.CommentRepository;
import com.sanix.Twitter.repositories.TweetRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;
    private final TweetService tweetService;
    private final TweetRepository tweetRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              UserServiceImpl userService,
                              TweetService tweetService,
                              TweetRepository tweetRepository) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.tweetService = tweetService;
        this.tweetRepository=tweetRepository;
    }

    @Override
    public Set<Comment> getComments(){
        Set<Comment> comments=new HashSet<>();
        commentRepository.findAll().iterator().forEachRemaining(comments::add);
        return comments;
    }

    @Override
    public Comment findById(Long l){
        Optional<Comment> comment=commentRepository.findById(l);

        if(! comment.isPresent()){
            throw new RuntimeException("comment "+ l+" not found");
        }
        return comment.get();
    }

    @Override
    public void createComment(CommentCreation commentCreation){
        Comment comment=new Comment();
        comment.setContent(commentCreation.getContent());
        String author_username=commentCreation.getAuthor_username();
        User user=userService.findByUsername(author_username);
        comment.setAuthor(user);
        Long tweet_id=commentCreation.getTweet_id();
        Tweet tweet=tweetService.findById(tweet_id);
        comment.setTweet(tweet);
        commentRepository.save(comment);
    }

    @Override
    public Set<Comment> CommentsByTweet(Long l){
        Optional <Tweet> tweetOptional=tweetRepository.findById(l);

        Tweet tweet=tweetOptional.get();

        return tweet.getComments();
    }

}
