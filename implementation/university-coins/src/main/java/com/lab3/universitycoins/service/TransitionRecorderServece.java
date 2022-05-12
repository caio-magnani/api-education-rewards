package com.lab3.universitycoins.service;

import com.lab3.universitycoins.model.TransitionRecorder;
import com.lab3.universitycoins.repository.TransitionRecorderRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class TransitionRecorderServece {

    @Autowired
    private static TransitionRecorderRepository transitions;

    public static void record(TransitionRecorder tr) {
        transitions.save(tr);
    }
}