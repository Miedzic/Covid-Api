package com.example.SpringFirstProject.country;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
// państwa p1  // ta klasa służy aby pościągać państwa i dane do niej do bazy danych

@Component
 class Client {
    // tutaj link do apify z którego ściągamy dane
    private static final String URL = "https://api.apify.com/v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST?disableRedirect=true";
    private RestTemplate restTemplate;
    private CountryFasade countryFasade;

    public Client(RestTemplate restTemplate, CountryFasade countryFasade) {
        this.restTemplate = restTemplate;
        this.countryFasade = countryFasade;
    }
    // p3 to oznacza że metoda będzie wywołana po starcie aplikacji
    @PostConstruct
    public void download() {
        // tutaj robimy zapytanie typu get na ustalony link, otrzymaną odpowiedź mapuje na tablicę obiektów typu apify country
        ApifyCountry[] restResponse = restTemplate.getForObject(URL, ApifyCountry[].class);
        //przerabiamy tablice na liste
        List<ApifyCountry> countries = Arrays.stream(restResponse)
                .collect(Collectors.toList());
        // wysyłamy listę do bazy danych za pośrednictwem fasady
        countryFasade.fillDatabase(countries);


    }
}
