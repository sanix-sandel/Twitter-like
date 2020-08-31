package com.sanix.Twitter.repositories;

import com.sanix.Twitter.models.Tweet;
import com.sanix.Twitter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
