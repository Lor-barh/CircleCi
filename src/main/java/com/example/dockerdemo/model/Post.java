package com.example.dockerdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@Getter
@Setter
public class Post {

    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
    private Long postId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany
    private List<Comment> comments;

    @OneToOne
    private Favourite favourite;
}