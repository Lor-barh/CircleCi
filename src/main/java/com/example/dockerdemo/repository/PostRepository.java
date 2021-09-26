package com.example.dockerdemo.repository;

import com.example.dockerdemo.model.Comment;
import com.example.dockerdemo.model.Post;
import com.example.dockerdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUser(User user);
}
