package com.example.SpringFirstProject.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class CountryController {


    CountryService countryService;

    CountryController(final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getCountryDetails")
    public Country getCountry(@RequestParam String name ) throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("Start");
       Country country = countryService.getCountryDetails(name);
        System.out.println(country);
        return country;
    }

    @PostMapping("/createCountry")
    public void createCountry(@RequestBody Country country ) throws InterruptedException, ExecutionException {
         countryService.saveCountryDetails(country);
    }

    @PutMapping("/updateCountry")
    public String updateCountry(@RequestBody Country country  ) throws InterruptedException, ExecutionException {
        return countryService.updateCountryDetails(country);
    }

    @DeleteMapping("/deleteCountry")
    public String deleteCountry(@RequestParam String name){
        return countryService.deleteCountry(name);
    }



}
