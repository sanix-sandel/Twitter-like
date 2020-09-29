package com.sanix.Twitter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=5, message="Comment must be at least 5 characters")
    private String content;

    @JsonManagedReference
    @ManyToOne
    private User author;

    @JsonBackReference
    @ManyToOne
    private Tweet tweet;

    private Instant created;

    @ManyToMany
    @JoinTable(name="tweet_user",
            joinColumns = @JoinColumn(name="tweet_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    private Set<User> likers=new HashSet<>();

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
