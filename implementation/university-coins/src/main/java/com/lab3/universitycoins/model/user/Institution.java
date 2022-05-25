package com.lab3.universitycoins.model.user;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class Institution extends LegalPersonUser {
    public Institution() {
        super("Institution");
    }

    public Institution(String name, String email, String password, String cnpj) {
        super(name, email, password, cnpj, "Institution");
    }
}
