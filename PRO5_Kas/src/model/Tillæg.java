package model;

public class Tillæg {
    private String name;
    private double pris;
    //Tvungen assocering til Hotel
    private Hotel hotel;

    public Tillæg(String name, double pris, Hotel hotel) {
        this.name = name;
        this.pris = pris;
        this.hotel = hotel;
    }

    public String getNavn() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
