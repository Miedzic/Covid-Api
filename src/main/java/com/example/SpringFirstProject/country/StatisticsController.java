package com.example.SpringFirstProject.country;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class StatisticsController {
    private CountryFasade countryFasade;

    public StatisticsController(CountryFasade countryFasade) {
        this.countryFasade = countryFasade;
    }

    @GetMapping("/statistics")
    ///statistics?sorted=true&sortingBy=name&direction=ascending
    public String getStatistics(boolean sorted, String sortingBy, String direction, Model model) {
        model.addAttribute("countries", countryFasade.getAllCountries(sorted, sortingBy, direction));

        return "statistics";

    }

}
