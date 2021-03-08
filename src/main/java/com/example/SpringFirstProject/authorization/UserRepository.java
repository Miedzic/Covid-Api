package com.example.SpringFirstProject.authorization;

import com.example.SpringFirstProject.authorization.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface UserRepository extends JpaRepository<User,Integer> {
    public User findByLogin(String mail);
}
