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

        contactRepository.save(contact);

    }

    @Override
    public void unfollow(ContactDTO contactDTO){

        Optional<User> followeropt=userRepository.findById(contactDTO.getFollower_id());
        Optional <User> followedopt=userRepository.findById(contactDTO.getFollowed_id());

        User follower=followeropt.get();
        User followed=followedopt.get();

        Contact contact=contactRepository.findAll()
                .stream()
                .filter(x->x.getFollower()==follower)
                .filter(x->x.getFollowed()==followed)
                .findFirst().get();
        contactRepository.delete(contact);

    }


}
