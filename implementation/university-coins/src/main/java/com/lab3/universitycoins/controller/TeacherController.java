package com.lab3.universitycoins.controller;

import java.util.ArrayList;

import com.lab3.universitycoins.model.TransitionRecorder;
import com.lab3.universitycoins.model.user.Student;
import com.lab3.universitycoins.model.user.Teacher;
import com.lab3.universitycoins.repository.StudentRepository;
import com.lab3.universitycoins.repository.TeacherRepository;
import com.lab3.universitycoins.repository.TransitionRecorderRepository;
import com.lab3.universitycoins.repository.UserRepository;

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
    UserRepository users;

    @Autowired
    StudentRepository students;

    @Autowired
    TeacherRepository teachers;

    @Autowired
    TransitionRecorderRepository transistions;

    @GetMapping
    public ArrayList<Teacher> getAllTeachers() {
        return (ArrayList<Teacher>) teachers.findAll();
    }

    @PostMapping
    public boolean insert(@RequestBody Teacher teacher) {
        boolean exist = users.existsByCpf(teacher.getCpf(), students, teachers)
                || users.existsByEmail(teacher.getEmail());
        if (exist)
            return false;
        teachers.save(teacher);
        return true;
    }

    @PostMapping("/update-teacher")
    public void update(@RequestBody Teacher teacher) {
        teachers.save(teacher);
    }

    @PostMapping("/delete-teacher")
    public void delete(@RequestBody Teacher teacher) {
        teachers.delete(teacher);
    }

    @PostMapping("/deposit")
    public boolean deposit(@RequestBody Long from, @RequestBody Long to, @RequestBody float howMuch,
            @RequestBody String motivation) {
        Teacher teacher = teachers.findById(from).get();
        Student student = students.findById(to).get();
        boolean hasSpend = teacher.bank.spend(howMuch);
        if (hasSpend) {
            student.bank.recive(howMuch);
            teachers.save(teacher);
            students.save(student);
            TransitionRecorder t = new TransitionRecorder(teacher, student);
            t.deposit(teacher, student, howMuch, motivation);
            transistions.save(t);
        }
        return hasSpend;
    }
}