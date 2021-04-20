package com.example.SpringFirstProject.statistics;

import com.example.SpringFirstProject.country.CountryDTO;
import com.example.SpringFirstProject.country.CountryFasade;
import com.example.SpringFirstProject.country.CountryStatisticsDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class StatisticsFasade {
    private CountryFasade countryFasade;

    public StatisticsFasade(CountryFasade countryFasade) {
        this.countryFasade = countryFasade;
    }
//pobieramy państwa i ich dane
    public List<CountryStatisticsDTO> getCountries(){
        return countryFasade.getAllCountries();
    }
    public CountryDTO getCountry(String country){
    return countryFasade.getCountryByName(country);  //TODO wyjatki!
    }
//tutaj dodajemy statystyki wszystkich państw w globalne
    public GlobalDTO getGlobal(){
        GlobalDTO globalDTO = new GlobalDTO();
        List<CountryStatisticsDTO> listOfCountries = getCountries();
        listOfCountries.forEach((country)->{
            globalDTO.totalInfected+=country.infected;
            globalDTO.totalRecovered+=country.recovered;
            globalDTO.totalDeceased+=country.deceased;
            globalDTO.totalTested+=country.tested;
        });
        //odejmujemy martwych i wyleczonych od zarażonych by uzyskać aktywnych zarażonych
        globalDTO.activeInfected=globalDTO.totalInfected-globalDTO.totalDeceased-globalDTO.totalRecovered;
        return globalDTO;
    }
}
