package com.lab3.universitycoins.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import com.lab3.universitycoins.model.user.Student;
import com.lab3.universitycoins.repository.StudentRepository;
import com.lab3.universitycoins.repository.TeacherRepository;
import com.lab3.universitycoins.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentRepository students;
    @Autowired
    private TeacherRepository teachers;
    @Autowired
    private UserRepository users;

    @GetMapping
    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>) students.findAll();

    }

    @PostMapping("/update-student")
    public void update(@RequestBody Student student) {
        students.save(student);
    }

    @PostMapping("/delete-student")
    public void delete(@RequestBody Student student) {
        students.delete(student);
    }

    @PostMapping
    public boolean insert(@RequestBody Student student) {
        boolean exist = users.existsByCpf(student.getCpf(), students, teachers)
                || users.existsByEmail(student.getEmail());
        if (exist)
            return false;
        students.save(student);
        return true;
    }
}
