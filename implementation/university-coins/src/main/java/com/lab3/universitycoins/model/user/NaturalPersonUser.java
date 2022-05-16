package com.lab3.universitycoins.model.user;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NaturalPersonUser extends User {

    private String cpf;

    public NaturalPersonUser() {

    }

    public NaturalPersonUser(String type) {
        super(type);
    }

    public NaturalPersonUser(String name, String email, String senha, String cpf, String type) {
        super(name, email, senha, type);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
