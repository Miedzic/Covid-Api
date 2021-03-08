package com.example.SpringFirstProject.country;

import com.example.SpringFirstProject.country.Country;
import lombok.Getter;

import java.util.List;
@Getter
 class RestResponse {
    private List<Country> countries;

    @Override
    public String toString() {
        return "RestResponse{" +
                "cards=" + countries +
                '}';
    }
}
