package com.sanix.Twitter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;



@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Username is required")
    @Size(min=5, message="Username must be at least 5 characters")
    private String username;

    @Email
    @NotNull
    private String email;

    @JsonBackReference
    @OneToMany(cascade= CascadeType.ALL, mappedBy="author")
    private Set<Tweet> tweets=new HashSet<>();

    @JsonBackReference
    @OneToMany(cascade=CascadeType.ALL, mappedBy="author")
    private Set<Comment> comments=new HashSet<>();

    @NotBlank(message="Password is required")
    private String password;


    @ManyToMany
    @JoinTable(name="tweet_user",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="follower_id"))
    private Set<User> followers=new HashSet<>();

    @ManyToMany
    @JoinTable(name="tweet_user",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="following_id"))
    private Set<User> following;

    @ManyToMany
    @JoinTable(name="tweet_user",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="tweet_id"))
    private Set<Tweet> tweets_liked;

    public Set<Tweet> getTweets_liked() {
        return tweets_liked;
    }



    public void addTweetLiked(Tweet tweet){
        this.getTweets_liked().add(tweet);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Comment> getComments() {
        return comments;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public Set<User> getFollowing() {
        return following;
    }


    public void follow(User user){
        user.getFollowers().add(this);
        this.getFollowing().add(user);
    }

    public void unfollow(User user){
        user.getFollowers().remove(this);
        this.getFollowing().remove(user);
    }
}
