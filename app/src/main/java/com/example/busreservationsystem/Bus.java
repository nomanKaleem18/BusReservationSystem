package com.example.busreservationsystem;
public class Bus {
    private String departure;
    private String arrival;
    private String travelDate;
    private double price;

    // Default constructor (required for Firebase)
    public Bus() {
        // Default constructor required for calls to DataSnapshot.getValue(Bus.class)
    }

    // Parameterized constructor
    public Bus(String departure, String arrival, String travelDate, double price) {
        this.departure = departure;
        this.arrival = arrival;
        this.travelDate = travelDate;
        this.price = price;
    }

    // Getter and Setter methods

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
