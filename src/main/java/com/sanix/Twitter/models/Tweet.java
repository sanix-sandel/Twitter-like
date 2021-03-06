package com.sanix.Twitter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
//@Builder
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min=5, message="A tweet must be at least 5 characters and at most 140", max=140)
    private String content;


    @JsonManagedReference
    @ManyToOne(fetch=EAGER)
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private User author;


    @JsonManagedReference
    @OneToMany(cascade= CascadeType.ALL, mappedBy="tweet")
    private Set<Comment> comments=new HashSet<>();

    private Instant created;

    @ManyToMany
    @JoinTable(name="tweet_user",
                joinColumns = @JoinColumn(name="tweet_id"),
                inverseJoinColumns=@JoinColumn(name="user_id"))
    private Set<User> likers;

    public Set<User> getLikers() {
        return likers;
    }

    public void addLiker(User liker) {
        this.getLikers().add(liker);

    }

    public Integer getLikeCount() {

        return this.getLikers().size();
    }

    public Integer getCommentsCount(){
        return this.getComments().size();
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

        this.author=author;
        //author.addTweet(this);
        author.getTweets().add(this);
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
