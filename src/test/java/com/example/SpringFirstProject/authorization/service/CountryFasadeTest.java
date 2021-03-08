package com.example.SpringFirstProject.authorization.service;

import com.example.SpringFirstProject.country.CountryService;
import com.example.SpringFirstProject.country.client.ApifyCountry;
import com.example.SpringFirstProject.country.Country;
import com.example.SpringFirstProject.country.CountryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CountryFasadeTest {

    @Test
    void shouldMapApifyCountriesToCountries(){
        ApifyCountry apifyCountry =new ApifyCountry("Ireland", "130","11");
        ApifyCountry apifyCountry2 = new ApifyCountry("Poland","2300","200");


        CountryRepository countryRepository = Mockito.mock(CountryRepository.class);
        CountryService countryService = new CountryService(countryRepository);
        List<Country> countries = countryService.mapToCountries(List.of(apifyCountry, apifyCountry2));
        assertThat(countries.get(0).getName()).isEqualTo("Ireland");
    }

    @Test
    void shouldCheckIfSaveAllIsExecuted() {

    }

    @Test
    void getAllCountries() {
    }
}