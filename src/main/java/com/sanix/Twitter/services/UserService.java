package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;

import java.util.List;

public interface UserService {

    public void createUser(UserRegistration userRegistration);
    public List<User> getAll();
    public User findByUsername(String username);
    public User findById(Long id);
}
