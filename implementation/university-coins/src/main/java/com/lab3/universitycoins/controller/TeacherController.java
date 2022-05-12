package com.lab3.universitycoins.controller;

import java.util.ArrayList;

import com.lab3.universitycoins.model.user.Student;
import com.lab3.universitycoins.model.user.Teacher;
import com.lab3.universitycoins.repository.StudentRepository;
import com.lab3.universitycoins.repository.TeacherReposotory;
import com.lab3.universitycoins.repository.TransitionRecorderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
    @Autowired
    StudentRepository students;
    @Autowired
    TeacherReposotory teachers;
    @Autowired
    TransitionRecorderRepository transistions;

    @GetMapping
    public ArrayList<Teacher> getAllTeachers() {
        return (ArrayList<Teacher>) teachers.findAll();
    }

    @PostMapping
    public boolean insert(@RequestBody Teacher teacher) {
        if (teachers.existsByCpf(teacher.getCpf()) || teachers.existsByEmail(teacher.getEmail()))
            return false;
        // String name, String email, String senha, String cpf
        teachers.save(new Teacher(teacher.getName(), teacher.getEmail(), teacher.getSenha(), teacher.getCpf()));
        return true;
    }

    @PostMapping("/deposit")
    public boolean deposit(@RequestBody Long from, @RequestBody Long to, @RequestBody float howMuch) {
        Teacher teacher = teachers.findById(from).get();
        Student student = students.findById(to).get();
        boolean spend = teacher.bank.spend(howMuch);
        student.bank.recive(howMuch);
        teachers.save(teacher);
        students.save(student);
        return spend;
    }
}
