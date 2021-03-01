package com.example.SpringFirstProject.service;


import com.example.SpringFirstProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {


    private UserRepository repository;


    public UserServiceDetailsImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDetails userDetails = repository.findByLogin(login);
        if(userDetails == null){
            throw new UsernameNotFoundException("login error");
        }
        return userDetails;
    }
}
