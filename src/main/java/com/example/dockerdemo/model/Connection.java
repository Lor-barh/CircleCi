package com.example.dockerdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tbl_connection")
@AllArgsConstructor
@NoArgsConstructor
public class Connection {

    @Id
    @SequenceGenerator(name = "connection_sequence", sequenceName = "connection_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "connection_sequence")
    private Long connectionId;
    @OneToOne
    private User user;
    @ManyToMany
    private Set<User> connections;


}
