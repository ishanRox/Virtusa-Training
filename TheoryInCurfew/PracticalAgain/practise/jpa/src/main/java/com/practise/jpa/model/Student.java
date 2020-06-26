package com.practise.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Stu")
public class Student {

    private int id;
    private String lastName;
    private String firstName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
