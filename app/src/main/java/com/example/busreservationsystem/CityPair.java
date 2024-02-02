package com.example.busreservationsystem;

public class CityPair {
    private String city1;
    private String city2;
    private String date;

    public CityPair(String city1, String city2, String date) {
        this.city1 = city1;
        this.city2 = city2;
        this.date = date;
    }

    public String getCity1() {
        return city1;
    }

    public String getCity2() {
        return city2;
    }

    public String getDate() {
        return date;
    }
}
