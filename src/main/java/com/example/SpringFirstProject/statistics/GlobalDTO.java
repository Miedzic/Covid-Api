package com.example.SpringFirstProject.statistics;

import lombok.Builder;
import lombok.Data;

@Data
public class GlobalDTO {
    public GlobalDTO() {
    }

    public int totalInfected;
    public int totalTested;
    public int totalDeaceased;
    public int totalRecovered;
    public int activeInfected;
}
