package com.example.SpringFirstProject.country;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
@Builder
@Data
 class CountryDTO {
    private String name;
    private String infected;
    private String recovered;
    private String deceased;
    private String tested;
    private String countryImgURL;
    private String sourceLastUpdate;




}
