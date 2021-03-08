package com.example.SpringFirstProject.country;

import com.example.SpringFirstProject.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 interface CountryRepository extends JpaRepository<Country,String> {

}
