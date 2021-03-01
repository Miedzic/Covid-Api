package com.example.SpringFirstProject.client;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApifyCountry {

    private String country;
    private String infected;
    private String recovered;
    private String deceased;
    private LocalDateTime sourceLastUpdate;
    private String moreData;
    private String sourceURL;
    private String tested;
    private String countryImgURL;

    public ApifyCountry() {
    }

    @Override
    public String toString() {
        return "ApifyCountry{" +
                "country='" + country + '\'' +
                ", infected='" + infected + '\'' +
                ", recovered='" + recovered + '\'' +
                ", deceased='" + deceased + '\'' +
                ", sourceLastUpdate=" + sourceLastUpdate +
                ", moreData='" + moreData + '\'' +
                ", sourceURL='" + sourceURL + '\'' +
                ", tested='" + tested + '\'' +
                ", countryImgURL='" + countryImgURL + '\'' +
                '}';
    }
}
