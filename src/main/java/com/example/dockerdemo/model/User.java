package com.example.dockerdemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "tbl_user",
        uniqueConstraints = @UniqueConstraint(
                name = "email_username_unique",
                columnNames =
                {"email_address", "username"})
)
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    @Column(name = "email_address")
    private String email;
    private String password;

    @OneToMany
    private List<Post> posts;

    @OneToMany
    private List<Comment> comments;

    @OneToMany
    private List<Post> favouritePosts;

//    @OneToOne
//    private Connection connection;

//    private Set<User> connections;
}
