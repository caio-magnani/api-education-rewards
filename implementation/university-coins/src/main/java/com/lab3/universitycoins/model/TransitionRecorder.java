package com.lab3.universitycoins.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lab3.universitycoins.model.user.Student;
import com.lab3.universitycoins.model.user.Teacher;
import com.lab3.universitycoins.model.user.User;

@Table(name = "transitions")
@Entity
public class TransitionRecorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId1;

    private Long userId2;

    private String transition;

    private Date date;

    public TransitionRecorder() {
    }

    public TransitionRecorder(User from, User to) {
        this.userId1 = from.getId();
        this.userId2 = to.getId();
        this.date = Date.valueOf(LocalDate.now());
    }

    public Long getFrom() {
        return userId1;
    }

    public Long getTo() {
        return userId2;
    }

    public LocalDate getDate() {
        return date.toLocalDate();
    }

    public String getTransition() {
        return transition;
    }

    public void deposit(Teacher teacher, Student student, float howMuch) {
        this.transition = "You deposit " + howMuch + "coins to " + student.getName();
    }

    public void spend(Student student, float howMuch) {
        this.transition = "You spend " + howMuch + "coins";
    }

    public void recharge(Teacher teacher) {
        this.transition = "You recive a recharge of 1000 coins";
    }
}
