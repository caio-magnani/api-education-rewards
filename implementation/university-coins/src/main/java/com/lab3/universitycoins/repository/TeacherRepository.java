package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.Teacher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    @Query(value = "SELECT * FROM users WHERE USER_TYPE = 'Teacher'", nativeQuery = true)
    Iterable<Teacher> findAll();

    Teacher findByEmail(String email);
}
