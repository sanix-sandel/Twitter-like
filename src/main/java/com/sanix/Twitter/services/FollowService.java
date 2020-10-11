package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.ContactDTO;
import com.sanix.Twitter.models.User;

public interface FollowService {
    void follow(ContactDTO contactDTO);
    void unfollow(ContactDTO contactDTO);
}
