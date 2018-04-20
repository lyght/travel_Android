package com.example.gallien.assignement;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gallien on 17/04/2018.
 */

public class User {


    private String country;
    //private List<String> cities= new ArrayList<>();
    private String[] prout ;

    public User(String country, String[] prout) {

        this.country = country;
      //  this.cities = cities;
        this.prout=prout;
    }


    public String getCountry() {
        return country;
    }
    public String[] getProut() {

        return prout;}

    //public List<String> getCities() {return cities;}
}
