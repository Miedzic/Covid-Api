package com.example.SpringFirstProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class User {
    private String login;
    private String passwd;
    @Id
    @GeneratedValue
    private int id;

    public User(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passwd='" + passwd + '\'' +
                ", id=" + id +
                '}';
    }
}
