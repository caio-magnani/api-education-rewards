package com.lab3.universitycoins.model.user;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_user")
public class Teacher extends NaturalPersonUser {

    @Convert(converter = AccoontBankConverter.class)
    public AccontBank bank;

    public Teacher() {
        super("Teacher");
        bank = new AccontBank();
    }

    public Teacher(String name, String email, String password, String cpf) {
        super(name, email, password, cpf, "Teacher");
        bank = new AccontBank();
    }

}
