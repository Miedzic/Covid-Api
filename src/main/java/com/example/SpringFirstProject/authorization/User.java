package com.example.SpringFirstProject.authorization;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
// jednak tutaj 7 /// klasa entity to taka której obiekty przechowujemy w bazie danych
@Entity
//implementujemy interfejs na potrzeby spring security
 class User implements UserDetails {
    private String login;
    private String passwd;
    private String role = "ROLE_USER";
//każde entity musi mieć jako jedno z pól Id, klucz główny sqlowy
    @Id
    @GeneratedValue
    private int id;

    public User(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }
  // tutaj jest wymagany przez hibernate bezparametrowy konstruktor
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
    // wszyscy mają tą samą role
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return passwd;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
