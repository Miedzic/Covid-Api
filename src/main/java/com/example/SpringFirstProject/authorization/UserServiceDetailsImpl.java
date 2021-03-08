package com.example.SpringFirstProject.authorization;


import com.example.SpringFirstProject.authorization.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
 class UserServiceDetailsImpl implements UserDetailsService {


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
