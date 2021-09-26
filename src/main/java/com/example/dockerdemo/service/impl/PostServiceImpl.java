package com.example.dockerdemo.service.impl;

import com.example.dockerdemo.model.Post;
import com.example.dockerdemo.model.User;
import com.example.dockerdemo.repository.PostRepository;
import com.example.dockerdemo.repository.UserRepository;
import com.example.dockerdemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createPost(Post post, HttpSession session) {
        Optional<User> user = userRepository.findById(post.getUser().getUserId());
        System.out.println(user);
        User newUser;
        User user1 = new User();
        if(user.isPresent()){
            user1 = user.get();
            System.out.println(user1);
        }
        newUser = (User) session.getAttribute(user1.getUsername());
        if (newUser != null) {
            post.setUser(user1);
            postRepository.save(post);
            user1.getPosts().add(post);
            return post;
        } else
            throw new IllegalStateException("You are not logged in");
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllUserPosts(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new IllegalStateException(userName + "Not found"));
        return new ArrayList<>(postRepository.findAllByUser(user));
    }

}
