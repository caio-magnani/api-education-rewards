package com.lab3.universitycoins.repository;

import java.util.ArrayList;
import com.lab3.universitycoins.model.TransitionRecorder;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransitionRecorderRepository extends CrudRepository<TransitionRecorder, Long> {

    @Query(value = "SELECT * FROM TRANSITIONS WHERE ABOUT = :#{#id}", nativeQuery = true)
    ArrayList<TransitionRecorder> findAllByAbout(@Param("id") Long id);
}
