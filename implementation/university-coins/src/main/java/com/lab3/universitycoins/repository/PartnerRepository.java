package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.data.jpa.repository.Query;

public interface PartnerRepository extends CrudRepository<Partner, Long> {

    @Query(value = "SELECT * FROM user WHERE TYPE = 'Partner'", nativeQuery = true)
    Iterable<Partner> findAll();

    boolean existsByCnpj(String cnpj);
    
     
}
