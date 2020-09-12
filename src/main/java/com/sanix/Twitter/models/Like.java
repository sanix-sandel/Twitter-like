package com.sanix.Twitter.models;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Tweet tweet;

    @ManyToOne(fetch=LAZY)
    @JoinColumn(referencedColumnName = "id")
    private User user;
}
