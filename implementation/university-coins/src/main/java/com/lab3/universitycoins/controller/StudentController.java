package com.lab3.universitycoins.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.lab3.universitycoins.model.user.Student;
import com.lab3.universitycoins.repository.StudentRepository;

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

    @GetMapping
    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) students.findAll();

    }

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable Long id) {
        try {
            return this.students.findById(id).get();
        } catch (Exception e) {
            return new Student();
        }

    }

    @PostMapping
    public boolean insert(@RequestBody Student student) {
        if (students.existsByCpf(student.getCpf()) || students.existsByEmail(student.getEmail()))
            return false;
        students.save(student);
        return true;
    }

    @PostMapping(value = "/login")
    public boolean login(@RequestBody Student student) {
        Student savedStudent = students.findByEmail(student.getEmail());
        return student.login(savedStudent.getEmail(), savedStudent.getSenha());
    }
}
