package com.lab3.universitycoins.model.user;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class LegalPersonUser extends User {
    private String cnpj;

    public LegalPersonUser() {

    }

    public LegalPersonUser(String type) {
        super(type);
    }

    public LegalPersonUser(String name, String email, String senha, String cnpj, String type) {
        super(name, email, senha, type);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }
}
