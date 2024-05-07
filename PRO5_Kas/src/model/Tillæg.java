package model;

import java.util.ArrayList;

public class Tillæg {
    private String navn;
    private double pris;
    //Tvungen assocering til Hotel
    private Hotel hotel;

    public Tillæg(String Navn, double pris, Hotel hotel) {
        this.navn = Navn;
        this.pris = pris;
        this.hotel = hotel;
    }

    public String getNavn() {
        return navn;
    }

    public void setName(String name) {
        this.navn = name;
    }

    public double getPris() {
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

    @Override
    public String toString() {
        return getNavn();
    }
}
