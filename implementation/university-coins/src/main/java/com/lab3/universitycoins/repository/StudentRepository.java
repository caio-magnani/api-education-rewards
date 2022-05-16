package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query(value = "SELECT * FROM users WHERE USER_TYPE = 'Student'", nativeQuery = true)
    Iterable<Student> findAll();

    Student findByEmail(String email);
}
