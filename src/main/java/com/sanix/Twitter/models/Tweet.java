package com.sanix.Twitter.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=5, message="A tweet must be at least 5 characters")
    private String content;

    @ManyToOne//(fetch=LAZY)
    @JoinColumn(name="userid", referencedColumnName="id")
    private User author;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="tweet")
    private Set<Comment> comments;

    private Instant created;

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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
