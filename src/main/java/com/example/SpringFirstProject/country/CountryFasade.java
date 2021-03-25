package com.example.SpringFirstProject.country;

import com.example.SpringFirstProject.country.Country;
import com.example.SpringFirstProject.country.CountryDTO;
import com.example.SpringFirstProject.country.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
 public class CountryFasade {
    private CountryRepository countryRepository;

     CountryFasade(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

     void fillDatabase(List<ApifyCountry> rawCountries) {
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
                    .name(rawCountry.getCountry())
                    .infected(parseService(rawCountry.getInfected()))
                    .recovered(parseService(rawCountry.getRecovered()))
                    .deceased(parseService(rawCountry.getDeceased()))
                    .sourceLastUpdate(rawCountry.getLastUpdatedSource())
                    .tested(parseService(rawCountry.getTested()))
                    .build();

            countries.add(country);
        }
        return countries;
    }

     int parseService(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    public CountryDTO getCountryByName(String name){
         Country country = countryRepository.findCountryByName(name)
                 .orElseThrow( ()->  new CountryException("nie znaleziono country")) ;

          return   country.mapToDTO();
        }

    public List<CountryDTO> getAllCountries(boolean sorted, String sortingBy, String direction) {
        return countryRepository.findAll().stream()
                .sorted(generateComparator(sorted, sortingBy, direction))
                .map(country -> country.mapToDTO())
                .collect(Collectors.toList());

    }
    public List<CountryStatisticsDTO> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(country -> country.mapToStatisticDTO())
                .collect(Collectors.toList());

    }
     Comparator<Country> generateComparator(boolean sorted, String sortingBy, String direction){
        if(!sorted){
           return Comparator.comparing(Country::getName);
        }
        if (sortingBy.equals("name") && direction.equals("descending")) {
            return (c1, c2) -> c2.getName().compareTo(c1.getName());
        } else {
            return Comparator.comparing(Country::getName);
        }
    }
}
