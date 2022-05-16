package com.lab3.universitycoins.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.lab3.universitycoins.model.user.Student;
import com.lab3.universitycoins.repository.StudentRepository;
import com.lab3.universitycoins.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentRepository students;
    @Autowired
    private UserRepository users;

    @GetMapping
    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) students.findAll();

    }

    @PostMapping("/update")
    public void update(@RequestBody Student student) {
        students.save(student);
    }

    @PostMapping
    public boolean insert(@RequestBody Student student) {
        if (users.existsByCpf(student.getCpf()) || users.existsByEmail(student.getEmail()))
            return false;
        students.save(student);
        return true;
    }
}
