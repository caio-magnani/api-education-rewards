package com.lab3.universitycoins.controller;

import com.lab3.universitycoins.model.user.Suport;
import com.lab3.universitycoins.repository.SuportRepository;
import com.lab3.universitycoins.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suport")
public class SuportController {

    @Autowired
    UserRepository users;

    @Autowired
    SuportRepository suports;

    @PostMapping
    public boolean insert(@RequestBody Suport suport) {
        if (users.existsByEmail(suport.getEmail())) {
            return false;
        }
        suports.save(suport);
        return true;
    }
}
