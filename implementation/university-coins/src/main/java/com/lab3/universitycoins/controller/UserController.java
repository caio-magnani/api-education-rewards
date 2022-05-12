package com.lab3.universitycoins.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.lab3.universitycoins.model.user.User;
import com.lab3.universitycoins.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository users;

    @GetMapping
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) users.findAll();

    }

    @PostMapping(value = "/login")
    public String login(@RequestBody User user) {
        User userSaved = users.findByEmail(user.getEmail());
        return (userSaved.login(user.getEmail(), user.getSenha())) ? users.userTypeByEmail(user.getEmail())
                : "null";

    }
}
