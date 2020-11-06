package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.UserActionDto;
import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void createUser(UserRegistration userRegistration);
    List<User> getAll();
    User findByUsername(String username);
    User findById(Long id);
    List<User> usersToFollow(User user);
    //public void follow(UserActionDto userActionDto);
    //public void unfollow(UserActionDto userActionDto);
}
