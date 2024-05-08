package model;

import java.util.ArrayList;
//Kald alle arraylists
public class Hotel {
    private String name;
    private String adresse;
    private int singlePris;
    private int doublePris;
    private final ArrayList<Tillæg> tillæg = new ArrayList<>();
    private final ArrayList<Konference> konferencer = new ArrayList<>();
    private final ArrayList<HotelBooking> hotelBookinger = new ArrayList<>();

    public Hotel(String name, int singlePris, int doublePris) {
        this.name = name;
        this.singlePris = singlePris;
        this.doublePris = doublePris;
    }

    public String getNavn() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSinglePris() {
        return singlePris;
    }

    public int getDoublePris() {
        return doublePris;
    }

    public ArrayList<Konference> getKonferencer() {
        return konferencer;
    }

    public ArrayList<HotelBooking> getHotelBookinger() {
        return hotelBookinger;
    }

    public void addHotelBooking(HotelBooking hotelBooking){
        this.hotelBookinger.add(hotelBooking);
    }

    public void removeHotelBooking(HotelBooking hotelBooking) {
        this.hotelBookinger.remove(hotelBooking);
    }

    public void addKonference(Konference konference){
        this.konferencer.add(konference);
    }

    public void removeKonference(Konference konference) {
        this.konferencer.remove(konference);
    }

    public ArrayList<Tillæg> getTillæg() {
        return tillæg;
    }

    public void addTillæg(Tillæg tillæg) {
        this.tillæg.add(tillæg);
    }

    public void removeTillæg(Tillæg tillæg) {
        this.tillæg.remove(tillæg);
    }

    @Override
    public String toString() {
        return getNavn();
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }
    public void removeTillæg(Tillæg tillæg){
        this.tillæg.remove(tillæg);
    }

    public void setSinglePris(int singlePris) {
        this.singlePris = singlePris;
    }

    public void setDoublePris(int doublePris) {
        this.doublePris = doublePris;
    }
}