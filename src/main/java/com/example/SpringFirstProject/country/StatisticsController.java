package com.example.SpringFirstProject.country;

import com.example.SpringFirstProject.statistics.StatisticsFasade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class StatisticsController {
    private CountryFasade countryFasade;
    private StatisticsFasade statisticsFasade;
    public StatisticsController(CountryFasade countryFasade, final StatisticsFasade statisticsFasade) {
        this.countryFasade = countryFasade;
        this.statisticsFasade = statisticsFasade;
    }

    @GetMapping("/statistics")
    ///statistics?sorted=true&sortingBy=name&direction=ascending
    public String getStatistics(boolean sorted, String sortingBy, String direction, Model model) {
        model.addAttribute("countries", countryFasade.getAllCountries(sorted, sortingBy, direction));
        model.addAttribute("global", statisticsFasade.getGlobal());
        return "statistics";

    }

}
