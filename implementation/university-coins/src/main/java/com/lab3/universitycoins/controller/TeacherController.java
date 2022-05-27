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
    public boolean deposit(
            @RequestBody String[] params) {
        Long from = Long.parseLong(params[0]);
        Long to = Long.parseLong(params[1]);
        float howMuch = Float.parseFloat(params[2]);
        String motivation = params[3];
        Teacher teacher = teachers.findById(from).get();
        Student student = students.findById(to).get();
        boolean hasSpend = teacher.bank.spend(howMuch);
        if (hasSpend) {
            student.bank.recive(howMuch);
            teachers.save(teacher);
            students.save(student);
            TransitionRecorder teacherDeposit = new TransitionRecorder(teacher, teacher, student);
            TransitionRecorder studentRecive = new TransitionRecorder(student, teacher, student);
            teacherDeposit.deposit(teacher, student, howMuch, motivation);
            studentRecive.recive(teacher, howMuch);
            transistions.save(teacherDeposit);
            transistions.save(studentRecive);
        }
        return hasSpend;
    }
}