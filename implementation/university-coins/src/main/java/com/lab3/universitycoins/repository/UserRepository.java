package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select case when count(U.id)> 0 then true else false end FROM USER AS U JOIN TEACHER AS T JOIN STUDENT AS S WHERE t.cpf like '%cpf%' or s.cpf like '%cpf%'", nativeQuery = true)
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    User findByEmail(String email);

    @Query(value = "SELECT TYPE FROM users WHERE email = '%email%'", nativeQuery = true)
    String userTypeByEmail(@Param("email") String email);
}
