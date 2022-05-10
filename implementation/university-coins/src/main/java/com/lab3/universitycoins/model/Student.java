package com.lab3.universitycoins.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "student")
@Entity
public class Student extends NaturalPersonUser {

    public Student() {

    }

    public Student(String name, String email, String senha, String cpf) {
        super(name, email, senha, cpf);
    }

}
