package com.sanix.Twitter.bootstrap;

import com.sanix.Twitter.models.Comment;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.CommentRepository;
import com.sanix.Twitter.repositories.TweetRepository;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class TweetBootstrap implements ApplicationListener<ContextRefreshedEvent> {

   // private final CommentRepository commentRepository;
    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;


    public TweetBootstrap(CommentRepository commentRepository,
                          TweetRepository tweetRepository,
                          UserRepository userRepository) {
        //this.commentRepository = commentRepository;
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        tweetRepository.saveAll(getTweets());
    }

    private List<Tweet> getTweets(){

        List<Tweet> tweets=new ArrayList<>(2);

        Optional<User> ruthOptional=userRepository.findByUsername("Ruth");

        if(! ruthOptional.isPresent()){
            throw new RuntimeException("Expected user not found");
        }

        Optional<User> jesnaOptional=userRepository.findByUsername("Jesna");

        if(! jesnaOptional.isPresent()){
            throw new RuntimeException("Expected user not found");
        }

        User ruthuser=ruthOptional.get();
        User jesnauser=jesnaOptional.get();

        Tweet ruthtweet=new Tweet();
        ruthtweet.setContent("Yeah !");
        ruthtweet.setAuthor(ruthuser);
        //ruthuser.addTweet(ruthtweet);


        Tweet jesnatweet=new Tweet();
        jesnatweet.setContent("Wohaa !");
        jesnatweet.setAuthor(jesnauser);
        //jesnauser.addTweet(jesnatweet);
        jesnauser.getTweets().add(jesnatweet);
        ruthuser.getTweets().add(ruthtweet);



        tweets.add(ruthtweet);
        tweets.add(jesnatweet);

        return tweets;
    }

}
