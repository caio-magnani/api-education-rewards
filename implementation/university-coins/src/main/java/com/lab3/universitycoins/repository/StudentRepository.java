package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

}
