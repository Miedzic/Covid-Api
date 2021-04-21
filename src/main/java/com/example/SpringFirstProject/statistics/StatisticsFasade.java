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

    public List<CountryStatisticsDTO> getCountries(){
        return countryFasade.getAllCountries();
    }
    public CountryDTO getCountry(String country){
    return countryFasade.getCountryByName(country);  //TODO wyjatki!
    }

    public GlobalDTO getGlobal(){
        GlobalDTO globalDTO = new GlobalDTO();
        List<CountryStatisticsDTO> listOfCountries = getCountries();
        listOfCountries.forEach((country)->{
            globalDTO.totalInfected+=country.infected;
            globalDTO.totalRecovered+=country.recovered;
            globalDTO.totalDeceased+=country.deceased;
            globalDTO.totalTested+=country.tested;
        });
        globalDTO.activeInfected=globalDTO.totalInfected-globalDTO.totalDeceased-globalDTO.totalRecovered;
        return globalDTO;
    }
}
