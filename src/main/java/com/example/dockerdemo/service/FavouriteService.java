package com.example.dockerdemo.service;

import com.example.dockerdemo.model.Favourite;

import javax.servlet.http.HttpSession;

public interface FavouriteService {

    Favourite saveFavourite(Long userId, Long postId, HttpSession httpSession);
}
