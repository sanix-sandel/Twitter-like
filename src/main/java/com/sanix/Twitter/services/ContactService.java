package com.sanix.Twitter.services;

import com.sanix.Twitter.models.Contact;
import com.sanix.Twitter.models.User;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();
    List<User> getFollowers(User user);
    List<User> getFollowed(User user);
}
