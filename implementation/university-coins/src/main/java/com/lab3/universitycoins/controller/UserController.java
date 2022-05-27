package com.lab3.universitycoins.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.lab3.universitycoins.model.TransitionRecorder;
import com.lab3.universitycoins.model.user.User;
import com.lab3.universitycoins.repository.UserRepository;
import com.lab3.universitycoins.repository.StudentRepository;
import com.lab3.universitycoins.repository.TeacherRepository;
import com.lab3.universitycoins.repository.TransitionRecorderRepository;
import com.lab3.universitycoins.repository.InstitutionRepository;
import com.lab3.universitycoins.repository.PartnerRepository;
import com.lab3.universitycoins.repository.SuportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository users;
    @Autowired
    StudentRepository students;
    @Autowired
    TeacherRepository teachers;
    @Autowired
    PartnerRepository partners;
    @Autowired
    InstitutionRepository institutions;
    @Autowired
    SuportRepository suports;
    @Autowired
    TransitionRecorderRepository transitions;

    @GetMapping
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) users.findAll();

    }

    @PostMapping(value = "/login")
    public User login(@RequestBody User user) {
        User userSaved = users.findByEmail(user.getEmail());
        if (!userSaved.login(user.getEmail(), user.getPassword())) {
            return null;
        }
        switch (userSaved.getType()) {
            case "Student":
                return students.findById(userSaved.getId()).get();
            case "Teacher":
                return teachers.findById(userSaved.getId()).get();
            case "Partner":
                return partners.findById(userSaved.getId()).get();
            case "Intitution":
                return institutions.findById(userSaved.getId()).get();
            case "Suport":
                return suports.findById(userSaved.getId()).get();
        }
        return null;
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        if (users.existsById(id)) {
            users.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping("/transitions/{id}")
    public ArrayList<TransitionRecorder> getTransisitons(@PathVariable Long id) {
        return (ArrayList<TransitionRecorder>) transitions.findAllByAbout(id);
    }
}
