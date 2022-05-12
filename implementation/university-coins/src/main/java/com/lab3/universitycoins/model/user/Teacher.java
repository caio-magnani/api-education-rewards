package com.lab3.universitycoins.model.user;

import javax.persistence.Convert;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "T")
public class Teacher extends NaturalPersonUser {
    @Convert(converter = AccoontBankConverter.class)
    public AccontBank bank;

    public Teacher() {
    }

    public Teacher(String name, String email, String senha, String cpf) {
        super(name, email, senha, cpf);
        bank = new AccontBank();
    }

}
