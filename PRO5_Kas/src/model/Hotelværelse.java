package model;

import java.util.ArrayList;

public class HotelVærelse {

    private int nummer;
    private int pris;
    private EnumVærelser.Værelser værelseType; // Updated to store room type
    private Hotel hotel;
    private final ArrayList<Registration> registrationer = new ArrayList<>();
    private ArrayList<Tillæg> tillæg = new ArrayList<>();

    public void addTillæg(Tillæg tillæg) {
        this.tillæg.add(tillæg);
    }

    public HotelVærelse(int nummer, int pris, EnumVærelser.Værelser værelseType, Hotel hotel) {
        this.nummer = nummer;
        this.pris = pris;
        this.værelseType = værelseType;
        this.hotel = hotel;
    }

    public int getNummer() {
        return nummer;
    }

    public int getPris() {
        return pris;
    }

    public EnumVærelser.Værelser getVærelseType() {
        return værelseType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Registration> getRegistrationer() {
        return registrationer;
    }

    // Udregn tillægsprisen for værelset
    public double calculateTillægsPris() {
        double tillægPris = 0.0;
        for (Tillæg tillæg : this.tillæg) {
            tillægPris += tillæg.getPris();
        }
        return tillægPris;
    }
}
