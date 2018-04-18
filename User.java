package com.example.gallien.assignement;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gallien on 17/04/2018.
 */

public class User {


    private String country;
    private List<String> cities= new ArrayList<>();

    public User(String country, List<String> cities) {

        this.country = country;
        this.cities = cities;
    }

    @SerializedName("Country")
    public String getCountry() {
        return country;
    }

    public List<String> getCities() {
        return cities;
    }
}
