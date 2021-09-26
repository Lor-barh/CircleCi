package com.example.dockerdemo.repository;

import com.example.dockerdemo.model.Favourite;
import com.example.dockerdemo.model.Post;
import com.example.dockerdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {
    Favourite findFavouriteByPostAndUser(Post post, User user);
}
