package com.example.SpringFirstProject.controller;

import com.example.SpringFirstProject.service.CountryService;
import com.example.SpringFirstProject.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    private CountryService countryService;

    public StatisticsController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping("/statistics")
    public String getStatistics(Model model){
        model.addAttribute("countries",countryService.getAllCountries());
        return "statistics";

    }

}
