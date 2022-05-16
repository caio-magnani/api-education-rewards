package com.lab3.universitycoins.model.user;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Partner extends LegalPersonUser {
    public Partner() {
        super("Partner");
    }

    public Partner(String name, String email, String password, String cnpj) {
        super(name, email, password, cnpj, "Partner");
    }
}
