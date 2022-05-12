package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);

    User findByEmail(String email);

    @Query(value = "SELECT USER_TYPE FROM users WHERE email = :email", nativeQuery = true)
    String userTypeByEmail(@Param("email") String email);
}
