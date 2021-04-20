package com.example.SpringFirstProject.authorization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//2 ten kontroler odpowiada za rejestracje
@Controller
 class RegisterController {
    //do rejestracji wykorzystujemy logikę zamieszczoną w fasadzie autoryzacji (wzorzec)
    private AuthorizationFasade authorizationFasade;

    public RegisterController(AuthorizationFasade authorizationFasade) {
        this.authorizationFasade = authorizationFasade;
    }
// za wystawienie tej strony odpowiada ta adnotacja get mapping
    @GetMapping("/register")
    public String getRegisterPage(){
        return "register";
    }
 //4 to się uruchamia się w momencie gdy klikniemy przycisk zarejestruj
    @PostMapping("/register")
    /*zbieżność nazw parametrów metody z atrybutem name z inputu w register.html pozwala
    wstawić dane z formularza do metody                    te parametry         */
    public String postRegisterPage(String login, String passwd, Model model){
        //tutaj zbieram dane do obiektu userRequest
        UserRequest userRequest = new UserRequest(login,passwd);
        // i zlecam fasadzie zarejestrowanie użytkownika
        try {
            authorizationFasade.register(userRequest);
            /* w przypadku błędu załączam komunikat i wysyłam na podstronę error.hthml
         error html */
        }catch (RegisterServiceException e){
            model.addAttribute("error",e.getMessage());
            return "error";
        }
        return "index";
    }


}
