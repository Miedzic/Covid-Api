package com.example.SpringFirstProject.service;

import com.example.SpringFirstProject.client.ApifyCountry;
import com.example.SpringFirstProject.model.Country;
import com.example.SpringFirstProject.repository.CountryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
class CountryServiceTest {

    @Test
    void shouldMapApifyCountriesToCountries(){
        ApifyCountry apifyCountry =new ApifyCountry("Ireland", "130","11");
        ApifyCountry apifyCountry2 = new ApifyCountry("Poland","2300","200");


        CountryRepository countryRepository = Mockito.mock(CountryRepository.class);
        CountryService countryService = new CountryService(countryRepository);
        List<Country> countries = countryService.mapToCountries(List.of(apifyCountry, apifyCountry2));
        assertThat(countries.get(0).getCountry()).isEqualTo("Ireland");
    }

    @Test
    void shouldSaveCountriesToRepository() {
    }

    @Test
    void getAllCountries() {
    }
}