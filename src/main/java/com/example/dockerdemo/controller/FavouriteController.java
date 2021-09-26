package com.example.dockerdemo.controller;

import com.example.dockerdemo.model.Favourite;
import com.example.dockerdemo.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/favourite/")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping("add/{userId}/{postId}")
    public Favourite addPostToFavourite(@PathVariable  Long postId, @PathVariable Long userId, HttpSession session){
        return favouriteService.saveFavourite(postId, userId, session);
    }
}
