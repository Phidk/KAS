package model;

import java.util.ArrayList;

public class Hotelværelse {

    private int nummer;

    private int pris;

    private  EnumVærelser værelser;

    private Hotel hotel;

    private final ArrayList<Registration> registrationer = new ArrayList<>();


    public Hotelværelse(int nummer, int pris, EnumVærelser værelser, Hotel hotel) {
        this.nummer = nummer;
        this.pris = pris;
        this.værelser = værelser;
        this.hotel = hotel;
    }

    public int getNummer() {
        return nummer;
    }

    public int getPris() {
        return pris;
    }

    public EnumVærelser getVærelser() {
        return værelser;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Registration> getRegistrationer() {
        return registrationer;
    }
}
