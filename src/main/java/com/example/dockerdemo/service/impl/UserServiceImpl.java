package com.example.dockerdemo.service.impl;

import com.example.dockerdemo.model.User;
import com.example.dockerdemo.repository.UserRepository;
import com.example.dockerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);
    }

    @Override
    public User login(User user, HttpSession session) throws Exception {
        Optional<User> user1 = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (user1.isPresent()) {
            user = user1.get();
            System.out.println(user.getUsername());
            session.setAttribute(user.getUsername(), user);
            return user;
        } else
            throw new Exception("Data not found");
    }
}