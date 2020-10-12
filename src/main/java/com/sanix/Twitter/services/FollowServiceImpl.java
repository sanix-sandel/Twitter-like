package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.ContactDTO;
import com.sanix.Twitter.models.Contact;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.ContactRepository;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class FollowServiceImpl implements FollowService{

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    public FollowServiceImpl(UserRepository userRepository,
                             ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public void follow(ContactDTO contactDTO){
        Long follower_id=contactDTO.getFollower_id();
        Optional<User> followerOptional=userRepository.findById(follower_id);
        User follower=followerOptional.get();

        Long followed_id=contactDTO.getFollowed_id();
        Optional<User> followedOptional=userRepository.findById(followed_id);
        User followed=followedOptional.get();

        Contact contact=new Contact(followed, follower);
        followed.setContact(contact);
        follower.setContact(contact);

        userRepository.save(followed);
        userRepository.save(follower);
        contactRepository.save(contact);

    }

    /*@Override
    public void unfollow(ContactDTO contactDTO){
        Long follower_id=contactDTO.getFollower_id();
        Optional<User> followerOptional=userRepository.findById(follower_id);
        User follower=followerOptional.get();

        Long followed_id=contactDTO.getFollowed_id();
        Optional<User> followedOptional=userRepository.findById(followed_id);
        User followed=followedOptional.get();

        Contact contact=
        contactRepository.delete(contact);
        followed.deleteContact(contact);
        follower.deleteContact(contact);

        userRepository.save(follower);
        userRepository.save(followed);
    }*/
}
