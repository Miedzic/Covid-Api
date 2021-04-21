package com.example.SpringFirstProject.statistics;

import com.example.SpringFirstProject.country.CountryDTO;
import com.example.SpringFirstProject.country.CountryException;
import com.example.SpringFirstProject.country.CountryStatisticsDTO;
import org.apache.tomcat.jni.Global;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class StatisticsRestController {
    private StatisticsFasade statisticsFasade;

    public StatisticsRestController(StatisticsFasade statisticsFasade) {
        this.statisticsFasade = statisticsFasade;
    }
    @GetMapping("/api/countries")
    public ResponseEntity<?> getCountries(String name){
        if(name != null){
            try{
                return ResponseEntity.ok(statisticsFasade.getCountry(name));
            }
            catch(CountryException e){
                return ResponseEntity.notFound().build();
            }
        }
        else return ResponseEntity.ok(statisticsFasade.getCountries());
    }
    @GetMapping("/api/global")
    public ResponseEntity<GlobalDTO> getGlobal(){
        GlobalDTO globalDTO = statisticsFasade.getGlobal();
        return ResponseEntity.ok(globalDTO);
   };
    //pobierz statystyki panstw
    //pobierz satystyki wybranego panstwa
    //pobierz statystyki laczne wszystkich panstw(wszystkie zachorowania na covid)
}
