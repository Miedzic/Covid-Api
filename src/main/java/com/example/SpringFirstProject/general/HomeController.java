package com.example.SpringFirstProject.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
 class HomeController {

    @GetMapping ("/home")
    public String getHomepage(){
        return "index";
    }


}
