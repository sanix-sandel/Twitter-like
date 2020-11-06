package com.sanix.Twitter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Contact> contacts=new HashSet<>();

    @NotBlank(message="Password is required")
    private String password;

    private boolean active=true;

    private String roles;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    public Set<Contact> getContacts() {
        return contacts;
    }

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public void setContact(Contact contact){
        getContacts().add(contact);

    }

    public List<User> listOfFollowers(){

        return getContacts().stream().filter(x->x.getFollowed()==this)
                .map(x->x.getFollower())
                .collect(toList());
    }

    public List<User> listOfFollowed(){

        return getContacts().stream().filter(x->x.getFollower()==this)
                .map(x->x.getFollowed())
                .collect(toList());
    }



}
