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
 // statystyki s1
    // uruchamia się po wejściu w statystyki, umożliwia parametryzowanie
 //(np czy sortowane czy nie i po czym, zrobiliśmy jedno przykładowe sortowanie dla nazwy )
    @GetMapping("/statistics")
    ///statistics?sorted=true&sortingBy=name&direction=ascending
    public String getStatistics(boolean sorted, String sortingBy, String direction, Model model) {
        //prosimy fasadę o wygenerowanie danych na temat państw i wysyłamy do kontenera model aby były dostepne w htmlu
        model.addAttribute("countries", countryFasade.getAllCountries(sorted, sortingBy, direction));
        //dane zbiorcze
        model.addAttribute("global", statisticsFasade.getGlobal());
        return "statistics";

    }

}
