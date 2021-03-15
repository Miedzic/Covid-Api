package com.example.SpringFirstProject.authorization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
 class RegisterController {
    private AuthorizationFasade authorizationFasade;

    public RegisterController(AuthorizationFasade authorizationFasade) {
        this.authorizationFasade = authorizationFasade;
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterPage(String login, String passwd, Model model){
        UserRequest userRequest = new UserRequest(login,passwd);
        try {
            authorizationFasade.register(userRequest);
        }catch (RegisterServiceException e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
        return "index";
    }


}
