package com.example.dockerdemo.service.impl;

import com.example.dockerdemo.model.Favourite;
import com.example.dockerdemo.model.Post;
import com.example.dockerdemo.model.User;
import com.example.dockerdemo.repository.FavouriteRepository;
import com.example.dockerdemo.repository.PostRepository;
import com.example.dockerdemo.repository.UserRepository;
import com.example.dockerdemo.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavouriteRepository favouriteRepository;

    @Override
    public Favourite saveFavourite(Long userId, Long postId, HttpSession httpSession) {
        Favourite favourite = new Favourite();
        Optional<User> user = userRepository.findById(userId);
        User newUser;
        User user1 = new User();
        if (user.isPresent()) {
            user1 = user.get();
        }
        newUser = (User) httpSession.getAttribute(user1.getUsername());
        if (newUser != null) {
            Post currentPost;
            Optional<Post> post = postRepository.findById(postId);
            if (post.isPresent()) {
                System.out.println("----------->>>>>> "+post.get().getPostId());
//                currentPost = post.get();
                System.out.println("---------- "+ post.get().getTitle());
//                Optional<Favourite> favourite1 = favouriteRepository.findByPostId(favourite.getPost().getPostId());
//                if (favourite1.isEmpty()){
//                    favourite = favourite1.get();
//                    favourite.getFavouritePosts().add(currentPost);
                favourite = favouriteRepository.findFavouriteByPostAndUser(post.get(),user1);
                favourite.getUser().getFavouritePosts().add(post.get());
                favourite.setUser(user1);
                    favouriteRepository.save(favourite);
                    //postRepository.save(post.get());

//                }
//                System.out.println(Arrays.toString(new String[]{"======== " +
//                        Arrays.toString(favourite.getFavouritePosts().toArray())}));
                return favourite;
            } else
                throw new IllegalStateException("Post Not Found");
        } else
            throw new IllegalStateException("User not logged in");
    }
}

// currentPost = post.get();
//         comment.setUser(user1);
//         commentRepository.save(comment);
//         currentPost.getComments().add(comment);
//         postRepository.save(currentPost);
//         return comment;