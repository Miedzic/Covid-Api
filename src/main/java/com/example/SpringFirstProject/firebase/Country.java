package com.example.SpringFirstProject.firebase;
import com.example.SpringFirstProject.country.CountryDTO;
import com.example.SpringFirstProject.country.CountryStatisticsDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Builder
@Getter
 class Country {

    private String name;
    private long infected;
    private long recovered;
    private long deceased;
    private String  sourceLastUpdate;
    private long tested;
    private String countryImgURL;

    public Country() {
    }

    public Country(String countryName, long infected, long recovered, long deceased,
                   String sourceLastUpdate, long tested, String countryImgURL) {
        this.name = countryName;
        this.infected = infected;
        this.recovered = recovered;
        this.deceased = deceased;
        this.sourceLastUpdate = sourceLastUpdate;
        this.tested = tested;
        this.countryImgURL = countryImgURL;
    }
    public CountryDTO mapToDTO() {
        return CountryDTO.builder()
                .name(name)
                .infected(checkIfThereIsData(infected))
                .recovered(checkIfThereIsData(recovered))
                .deceased(checkIfThereIsData(deceased))
                .tested(checkIfThereIsData(tested))
                .sourceLastUpdate(checkIfThereIsData(sourceLastUpdate))
                .build();
    }
   /* public CountryStatisticsDTO mapToStatisticDTO(){
        return CountryStatisticsDTO.builder()
                .name(name)
                .infected(infected)
                .recovered(recovered)
                .deceased(deceased)
                .tested(tested)
                .build();
    }*/
    public String checkIfThereIsData(long data){
        if(data == -1){
            return "NO DATA ";
        }
        else  return String.valueOf(data);
    }
    public String checkIfThereIsData(String  data){
        if(data == null){
            return "NO DATA ";
        }
        else  return String.valueOf(data);
    }
    @Override
    public String toString() {
        return "Record{" +
                "countryTag='" + name + '\'' +
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
        return this.name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
