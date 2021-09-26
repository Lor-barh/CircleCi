package com.example.dockerdemo.controller;

import com.example.dockerdemo.model.Comment;
import com.example.dockerdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/comment/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("createComment")
    public Comment createPost(@RequestBody Comment comment, HttpSession session){
        return commentService.createComment(comment, session);
    }

    @GetMapping("getComment/{username}")
    public List <Comment> getAllUserComments(@PathVariable("username") String userName){
        return commentService.getAllUserComments(userName);
    }
}
