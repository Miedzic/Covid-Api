package com.example.SpringFirstProject.service;

import com.example.SpringFirstProject.model.User;
import com.example.SpringFirstProject.repository.UserRepository;
import com.example.SpringFirstProject.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private UserRepository userRepository;
    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void register(UserRequest userRequest){
        User user = new User(userRequest.getLogin(),userRequest.getPasswd());
         User existingUser = userRepository.findByLogin(userRequest.getLogin());
         if(existingUser == null){
             userRepository.save(user);
         }
        else throw new RegisterServiceException("istnieje już taki użytkownik pozdrawiam cieplutko ");
        System.out.println(userRepository.findAll());


    }


}
