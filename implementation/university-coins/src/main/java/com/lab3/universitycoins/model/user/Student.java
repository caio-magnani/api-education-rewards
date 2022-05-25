package com.lab3.universitycoins.model.user;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class Student extends NaturalPersonUser {

    @Convert(converter = AccoontBankConverter.class)
    public AccontBank bank;

    public Student() {
        super("Student");
        bank = new AccontBank();
    }

    public Student(String name, String email, String password, String cpf) {
        super(name, email, password, cpf, "Student");
        bank = new AccontBank();
    }

}
