package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.TransitionRecorder;

import org.springframework.data.repository.CrudRepository;

public interface TransitionRecorderRepository extends CrudRepository<TransitionRecorder, Long> {
    TransitionRecorder findByUserId1(Long from);

    TransitionRecorder findByUserId2(Long to);
}
