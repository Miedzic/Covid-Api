package com.example.SpringFirstProject.country;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryStatisticsDTO {
    private String name;
    public int infected;
    public int recovered;
    public int deceased;
    public int tested;
}
