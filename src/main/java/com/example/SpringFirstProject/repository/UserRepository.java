package com.example.SpringFirstProject.repository;

import com.example.SpringFirstProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByLogin(String mail);
}
