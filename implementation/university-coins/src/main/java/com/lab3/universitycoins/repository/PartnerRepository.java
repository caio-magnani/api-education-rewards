package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartnerRepository extends CrudRepository<Partner, Long> {

    @Query(value = "SELECT * FROM USER U JOIN PARTNER P ON U.ID = P.ID_USER", nativeQuery = true)
    Iterable<Partner> findAll();

    boolean existsByCnpj(String cnpj);

}
