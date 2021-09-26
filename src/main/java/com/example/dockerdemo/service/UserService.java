package com.example.dockerdemo.service;

import com.example.dockerdemo.model.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    User register(User user);

    User login(User user, HttpSession session) throws Exception;
}
