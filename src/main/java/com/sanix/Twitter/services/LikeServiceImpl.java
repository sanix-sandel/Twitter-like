package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.LikeDTO;
import com.sanix.Twitter.models.LikeAction;
import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.LikeRepository;
import com.sanix.Twitter.repositories.TweetRepository;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService{

    private final LikeRepository likeRepository;

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public LikeServiceImpl(LikeRepository likeRepository,
                           TweetRepository tweetRepository,
                           TweetRepository tweetRepository1,
                           UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.tweetRepository = tweetRepository;

        this.userRepository = userRepository;
    }

    @Override
    public void LikeAction(LikeDTO likeDTO){
        LikeAction like=new LikeAction();
        Optional <User> userOptional=userRepository.findById(likeDTO.getUser_id());
        Optional<Tweet> tweetOptional=tweetRepository.findById(likeDTO.getTweet_id());

        if(! (tweetOptional.isPresent() && userOptional.isPresent())){
            throw new RuntimeException("User or tweet not found");
        }
        Tweet tweet=tweetOptional.get();
        User user=userOptional.get();
        tweet.setLikeCount(tweet.getLikeCount()+1);
        tweetRepository.save(tweet);
        likeRepository.save(like);

    }
}
