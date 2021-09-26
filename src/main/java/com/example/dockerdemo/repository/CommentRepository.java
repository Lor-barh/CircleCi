package com.example.dockerdemo.repository;

import com.example.dockerdemo.model.Comment;
import com.example.dockerdemo.model.Post;
import com.example.dockerdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByUser(User user);

}
