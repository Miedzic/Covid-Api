package com.example.SpringFirstProject.country;

import lombok.Getter;


@Getter
//p2 to jest model danych który łapie treści otrzymane z apify
 class ApifyCountry {

    private String country;
    private String infected;
    private String recovered;
    private String deceased;
    private String lastUpdatedSource;
    private String moreData;
    private String sourceURL;
    private String tested;
    private String countryImgURL;


    public ApifyCountry() {
    }

    public ApifyCountry(String country, String infected, String deceased) {
        this.country = country;
        this.infected = infected;
        this.deceased = deceased;
    }

    @Override
    public String toString() {
        return "ApifyCountry{" +
                "country='" + country + '\'' +
                ", infected='" + infected + '\'' +
                ", recovered='" + recovered + '\'' +
                ", deceased='" + deceased + '\'' +
                ", sourceLastUpdate=" + lastUpdatedSource +
                ", moreData='" + moreData + '\'' +
                ", sourceURL='" + sourceURL + '\'' +
                ", tested='" + tested + '\'' +
                ", countryImgURL='" + countryImgURL + '\'' +
                '}';
    }
}
