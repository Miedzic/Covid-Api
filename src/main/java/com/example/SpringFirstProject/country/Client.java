package com.example.SpringFirstProject.country;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
 class Client {
    private static final String URL = "https://api.apify.com/v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST?disableRedirect=true";
    private RestTemplate restTemplate;
    private CountryFasade countryFasade;

    public Client(RestTemplate restTemplate, CountryFasade countryFasade) {
        this.restTemplate = restTemplate;
        this.countryFasade = countryFasade;
    }

    @PostConstruct
    public void download() {

        ApifyCountry[] restResponse = restTemplate.getForObject(URL, ApifyCountry[].class);

        List<ApifyCountry> countries = Arrays.stream(restResponse)
                .collect(Collectors.toList());

        countryFasade.fillDatabase(countries);


    }
}
