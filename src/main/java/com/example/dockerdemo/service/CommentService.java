package com.example.dockerdemo.service;

import com.example.dockerdemo.model.Comment;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment, HttpSession session);

    List<Comment> getAllUserComments(String userName);
}