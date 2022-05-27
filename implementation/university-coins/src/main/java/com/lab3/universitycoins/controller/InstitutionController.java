package com.lab3.universitycoins.controller;

import com.lab3.universitycoins.model.TransitionRecorder;
import com.lab3.universitycoins.model.user.Teacher;
import com.lab3.universitycoins.model.user.User;
import com.lab3.universitycoins.repository.TeacherRepository;
import com.lab3.universitycoins.repository.TransitionRecorderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institution")
public class InstitutionController {
    private User system = new User("System", "none", "none", "System");

    @Autowired
    TeacherRepository teachers;

    @Autowired
    TransitionRecorderRepository transitions;

    @GetMapping("/recharge")
    public void rechargeAllTeachers() {
        for (Teacher teacher : teachers.findAll()) {
            teacher.bank.recive(Float.valueOf(1000));
            this.system.setId(Long.valueOf(-1));
            TransitionRecorder record = new TransitionRecorder(teacher, this.system, teacher);
            record.recharge(teacher);
            transitions.save(record);
        }
    }
}
