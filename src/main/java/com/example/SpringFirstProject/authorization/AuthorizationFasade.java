package com.example.SpringFirstProject.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationFasade {
/* 6 w tym serwisie wykorzystujemy klase dostępu userRepository do bazy danych
oraz algortytm haszowania hasła pochodzący ze springSecurity   */
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthorizationFasade(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    void register(UserRequest userRequest) {
//budujemy tutaj obiekt encji bazodanowej na bazie obiektu transportowego // zajrzeć do USER
        User user = new User(userRequest.getLogin(), passwordEncoder.encode(userRequest.getPasswd()));
        //szukamy czy mamy już takiego użytkownika w bazie, jak nie to tworzymy metodą save,
        // w przeciwnym wypadku rzucamy wyjątek i kierujemy do error
        User existingUser = userRepository.findByLogin(userRequest.getLogin());
        if (existingUser == null) {
            userRepository.save(user);
        } else throw new RegisterServiceException("istnieje już taki użytkownik pozdrawiam cieplutko ");
    }
//logowania nie ma bo zostało zautomatyzowane przy pomocy spring security, ustawienia znajdują się w web security config

}
