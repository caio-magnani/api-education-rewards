package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.Teacher;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeacherReposotory extends CrudRepository<Teacher, Long> {
    @Query(value = "SELECT * FROM users WHERE USER_TYPE = 'Teacher'", nativeQuery = true)
    Iterable<Teacher> findAll();

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    Teacher findByEmail(String email);
}
