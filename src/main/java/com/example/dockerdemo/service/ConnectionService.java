package com.example.dockerdemo.service;

import com.example.dockerdemo.model.Connection;

import javax.servlet.http.HttpSession;

public interface ConnectionService {

    Connection saveConnection(Connection connection, String username, HttpSession session);
}
