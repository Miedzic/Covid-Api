package com.example.SpringFirstProject.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
@Builder
@Entity
@Getter
public class Country {
    @Id
    private String country;
    private int infected;
    private int recovered;
    private int deceased;
    private LocalDateTime  sourceLastUpdate;
    private int tested;
    private String countryImgURL;

    public Country() {
    }

    public Country(String countryName, int infected, int recovered, int deceased,
                   LocalDateTime sourceLastUpdate, int tested, String countryImgURL) {
        this.country = countryName;
        this.infected = infected;
        this.recovered = recovered;
        this.deceased = deceased;
        this.sourceLastUpdate = sourceLastUpdate;
        this.tested = tested;
        this.countryImgURL = countryImgURL;
    }

    @Override
    public String toString() {
        return "Record{" +
                "countryTag='" + country + '\'' +
                ", infected=" + infected +
                ", recovered=" + recovered +
                ", deceased=" + deceased +
                ", sourceLastUpdate=" + sourceLastUpdate +
                ", tested=" + tested +
                ", countryImgURL='" + countryImgURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return this.country.equals(country.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country);
    }
}
