package com.lab3.universitycoins.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NaturalPersonUser extends User {

    private String cpf;

    public NaturalPersonUser() {

    }

    public NaturalPersonUser(String name, String email, String senha, String cpf) {
        super(name, email, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
