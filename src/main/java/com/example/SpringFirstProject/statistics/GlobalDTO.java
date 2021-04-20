package com.example.SpringFirstProject.statistics;

import lombok.Builder;
import lombok.Data;
//tutaj zwyczajnie trzymamy nasze dane statystyk globalnych
@Data
public class GlobalDTO {
    public GlobalDTO() {
    }

    public long totalInfected;
    public long totalTested;
    public long totalDeceased;
    public long totalRecovered;
    public long activeInfected;
}

