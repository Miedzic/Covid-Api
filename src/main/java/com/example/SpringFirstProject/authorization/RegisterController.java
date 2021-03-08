package com.example.SpringFirstProject.authorization;

import com.example.SpringFirstProject.authorization.UserRequest;
import com.example.SpringFirstProject.authorization.RegisterService;
import com.example.SpringFirstProject.authorization.RegisterServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
 class RegisterController {
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
