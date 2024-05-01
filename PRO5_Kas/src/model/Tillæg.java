package model;

import java.util.ArrayList;

public class Tillæg {
    private String name;
    private int pris;
    //Tvungen assocering til Hotel
    private Hotel hotel;

    public Tillæg(String name, int pris, Hotel hotel) {
        this.name = name;
        this.pris = pris;
        this.hotel = hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public Hotel getHotel(){
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
