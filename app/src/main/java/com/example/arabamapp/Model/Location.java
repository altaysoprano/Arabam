package com.example.arabamapp.Model;

public class Location {

    private String cityName;
    private String townName;

    public Location(String cityName, String townName) {
        this.cityName = cityName;
        this.townName = townName;
    }

    // Getter Methods

    public String getCityName() {
        return cityName;
    }

    public String getTownName() {
        return townName;
    }

    // Setter Methods

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}