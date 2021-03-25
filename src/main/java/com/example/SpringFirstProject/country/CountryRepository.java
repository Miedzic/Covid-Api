package com.example.SpringFirstProject.country;

import com.example.SpringFirstProject.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
 interface CountryRepository extends JpaRepository<Country,String> {

 public Optional<Country> findCountryByName(String name);

}
