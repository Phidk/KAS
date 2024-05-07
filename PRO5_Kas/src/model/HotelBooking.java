package model;

import java.util.ArrayList;

public class HotelBooking {

    private int nummer;
    private EnumVærelser.Værelser værelseType;
    private Hotel hotel;
    private final ArrayList<Registration> registrationer = new ArrayList<>();
    private ArrayList<Tillæg> tillæg = new ArrayList<>();


    public HotelBooking(int nummer, int pris, EnumVærelser.Værelser værelseType, Hotel hotel) {
        this.nummer = nummer;
        this.værelseType = værelseType;
        this.hotel = hotel;
    }
    public int getNummer() {
        return nummer;
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

    public double calculateVærelsesPris() {
        double værelsesPris = 0;
        if (værelseType == EnumVærelser.Værelser.SINGLE) {
            værelsesPris = hotel.getSinglePris();
        } else if (værelseType == EnumVærelser.Værelser.DOUBLE) {
            værelsesPris = hotel.getDoublePris();
        }
        return værelsesPris;
    }

    public ArrayList<Tillæg> getTillæg() {
        return tillæg;
    }

    public void addTillæg(Tillæg tillæg) {
        this.tillæg.add(tillæg);
    }
    public void removeTillæg(Tillæg tillæg){
        this.tillæg.remove(tillæg);
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
