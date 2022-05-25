package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.Institution;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InstitutionRepository extends CrudRepository<Institution, Long> {

    @Query(value = "SELECT * FROM user WHERE TYPE = 'Institution'", nativeQuery = true)
    Iterable<Institution> findAll();

    boolean existsByCnpj(String cnpj);
}
