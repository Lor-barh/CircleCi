package com.example.dockerdemo.controller;

import com.example.dockerdemo.model.User;
import com.example.dockerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public User saveUser(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("login")
    public User getUser(@RequestBody  User user, HttpSession session) throws Exception {
        return userService.login(user, session);
    }

}
