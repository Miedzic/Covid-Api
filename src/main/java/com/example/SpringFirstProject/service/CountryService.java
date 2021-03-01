package com.example.SpringFirstProject.service;

import com.example.SpringFirstProject.client.ApifyCountry;
import com.example.SpringFirstProject.model.Country;
import com.example.SpringFirstProject.repository.CountryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void fillDatabase(List<ApifyCountry> rawCountries) {
        if (countryRepository.count() > 0) {
            return;
        }
        List<Country> countries = mapToCountries(rawCountries);
        countryRepository.saveAll(countries);
    }

    List<Country> mapToCountries(List<ApifyCountry> rawCountries) {
        List<Country> countries = new ArrayList<>();
        for (ApifyCountry rawCountry : rawCountries) {
            Country country = Country.builder()
                    .country(rawCountry.getCountry())
                    .infected(parseService(rawCountry.getInfected()))
                    .recovered(parseService(rawCountry.getRecovered()))
                    .deceased(parseService(rawCountry.getDeceased()))
                    .sourceLastUpdate(rawCountry.getSourceLastUpdate())
                    .tested(parseService(rawCountry.getTested()))
                    .build();

            countries.add(country);
        }
        return countries;
    }


    public int parseService(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }

    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
