package com.example.SpringFirstProject.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationFasade {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthorizationFasade(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    void register(UserRequest userRequest) {

        User user = new User(userRequest.getLogin(), passwordEncoder.encode(userRequest.getPasswd()));
        User existingUser = userRepository.findByLogin(userRequest.getLogin());
        if (existingUser == null) {
            userRepository.save(user);
        } else throw new RegisterServiceException("istnieje już taki użytkownik pozdrawiam cieplutko ");
    }

}
