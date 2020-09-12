package com.sanix.Twitter.models;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class LikeAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Tweet tweet;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(referencedColumnName = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
