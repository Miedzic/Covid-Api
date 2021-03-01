package com.example.SpringFirstProject.client;

import com.example.SpringFirstProject.model.Country;
import lombok.Getter;

import java.util.List;
@Getter
public class RestResponse {
    private List<Country> countries;

    @Override
    public String toString() {
        return "RestResponse{" +
                "cards=" + countries +
                '}';
    }
}
