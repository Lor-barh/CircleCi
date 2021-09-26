package com.example.dockerdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tbl_favourites")
public class Favourite {

    @Id
    @SequenceGenerator(
            name = "favourite_sequence",
            sequenceName = "favourite_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favourite_sequence")
    private Long favouriteId;
    private String favouriteName;
    @OneToMany
    private Set<Post> post;
    @ManyToOne
    private User user;
}
