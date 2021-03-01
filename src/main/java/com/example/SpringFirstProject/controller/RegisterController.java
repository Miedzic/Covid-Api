package com.example.SpringFirstProject.controller;

import com.example.SpringFirstProject.request.UserRequest;
import com.example.SpringFirstProject.service.RegisterService;
import com.example.SpringFirstProject.service.RegisterServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(String login, String passwd, Model model){
        UserRequest userRequest = new UserRequest(login,passwd);
        try {
            registerService.register(userRequest);
        }catch (RegisterServiceException e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
        return "index";
    }


}
