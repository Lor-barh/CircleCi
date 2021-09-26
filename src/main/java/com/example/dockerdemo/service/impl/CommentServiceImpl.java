package com.example.dockerdemo.service.impl;

import com.example.dockerdemo.model.Comment;
import com.example.dockerdemo.model.Post;
import com.example.dockerdemo.model.User;
import com.example.dockerdemo.repository.CommentRepository;
import com.example.dockerdemo.repository.PostRepository;
import com.example.dockerdemo.repository.UserRepository;
import com.example.dockerdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    @Override
    public Comment createComment(Comment comment, HttpSession session) {

        Optional<User> user = userRepository.findById(comment.getUser().getUserId());
        User newUser;
        User user1 = new User();
        if (user.isPresent()) {
            user1 = user.get();
        }
        newUser = (User) session.getAttribute(user1.getUsername());
        if (newUser != null) {
            Post currentPost = new Post();
            Optional<Post> post = postRepository.findById(comment.getPost().getPostId());
            if (post.isPresent()) {
                currentPost = post.get();
                comment.setUser(user1);
                commentRepository.save(comment);
                currentPost.getComments().add(comment);
                postRepository.save(currentPost);
                return comment;
            } else
                throw new IllegalStateException("Post Not found");
        } else
            throw new IllegalStateException("You are not logged In");
    }

    @Override
    public List<Comment> getAllUserComments(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new IllegalStateException(userName + "Not found"));
        return new ArrayList<>(commentRepository.findAllByUser(user));
    }

}
