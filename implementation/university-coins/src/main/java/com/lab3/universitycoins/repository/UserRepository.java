package com.lab3.universitycoins.repository;

import com.lab3.universitycoins.model.user.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    public default boolean existsByCpf(String cpf, StudentRepository students, TeacherRepository teachers) {
        return students.existsByCpf(cpf) || teachers.existsByCpf(cpf);
    }

    public default boolean existsByCnpj(String cnpj, PartnerRepository partners, InstitutionRepository institutions) {
        return partners.existsByCnpj(cnpj) || institutions.existsByCnpj(cnpj);
    }

    boolean existsByEmail(String email);

    User findByEmail(String email);

    @Query(value = "SELECT TYPE FROM user WHERE email = '%email%'", nativeQuery = true)
    abstract String userTypeByEmail(@Param("email") String email);
}
