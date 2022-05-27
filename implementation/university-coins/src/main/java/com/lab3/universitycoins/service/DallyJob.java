package com.lab3.universitycoins.service;

import java.util.ArrayList;

import com.lab3.universitycoins.model.TransitionRecorder;
import com.lab3.universitycoins.model.user.Teacher;
import com.lab3.universitycoins.repository.TeacherRepository;
import com.lab3.universitycoins.repository.TransitionRecorderRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class DallyJob {

    @Autowired
    TeacherRepository teachers;

    @Autowired
    TransitionRecorderRepository transitions;

    public void recharge() {
        ArrayList<Teacher> allTeachers = (ArrayList<Teacher>) teachers.findAll();
        ArrayList<Long> ids = new ArrayList<>();
        ArrayList<TransitionRecorder> allSistemTransitions = new ArrayList<>();
        ids.add(Long.valueOf(-1));
        allSistemTransitions = (ArrayList<TransitionRecorder>) transitions.findAllById(ids);
    }
}