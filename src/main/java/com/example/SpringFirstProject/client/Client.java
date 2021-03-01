package com.example.SpringFirstProject.client;

import com.example.SpringFirstProject.service.CountryService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Client {
    private static final String URL = "https://api.apify.com/v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST?disableRedirect=true";
    private RestTemplate restTemplate;
    private CountryService countryService;

    public Client(RestTemplate restTemplate, CountryService countryService) {
        this.restTemplate = restTemplate;

        this.countryService = countryService;
    }

    @PostConstruct
    public void download() {

        ApifyCountry[] restResponse = restTemplate.getForObject(URL, ApifyCountry[].class);
        List<ApifyCountry> countries = Arrays.stream(restResponse)
                .collect(Collectors.toList());
        System.out.println(countries);
        countryService.fillDatabase(countries);

    }
}
