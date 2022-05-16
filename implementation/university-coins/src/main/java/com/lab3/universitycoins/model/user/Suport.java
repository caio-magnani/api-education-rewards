package com.lab3.universitycoins.model.user;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Suport extends User {
    public Suport() {
        super("Suport");
    }

    public Suport(String name, String email, String password) {
        super(name, email, password, "Suport");
    }
}
