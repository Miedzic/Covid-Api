package com.example.SpringFirstProject.country;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
 public class CountryDTO {
    private String name;
    private String infected;
    private String recovered;
    private String deceased;
    private String tested;
    private String countryImgURL;
    private String sourceLastUpdate;
}
