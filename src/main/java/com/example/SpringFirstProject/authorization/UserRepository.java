package com.example.SpringFirstProject.authorization;

import com.example.SpringFirstProject.authorization.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// to repozytorium wykorzystuje spring JPA dzięki czemu generują nam się automatycznie metody dostępu do bazy danych
// na podstawie sygnatur metod abstrakcyjnych
@Repository
 interface UserRepository extends JpaRepository<User,Integer> {
    public User findByLogin(String mail);
}
