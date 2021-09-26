package com.example.dockerdemo.controller;

import com.example.dockerdemo.model.Connection;
import com.example.dockerdemo.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/connection/")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @PostMapping("saveConnection/{username}")
    public Connection saveConnection(@RequestBody Connection connection, @PathVariable String username, HttpSession session) {
    return connectionService.saveConnection(connection,username,session);
    }
}
