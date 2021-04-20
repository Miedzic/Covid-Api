package com.example.SpringFirstProject.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//1 ten kontroler odpowiada za wyświetlanie strony głównej
@Controller
//to jest opcjonalne, można w sumie nie wspominać nic żeby nie spytał niepotrzebnie
@RequestMapping
 class HomeController {
    //wskazujemy że zapytania http typu get na podstrone home mają wywołać te metode
    @GetMapping ("/home")
    // metoda zwracają stringa wskazuje plik html który ma być wysłany
    public String getHomepage(){
        return "index";
    }


}
