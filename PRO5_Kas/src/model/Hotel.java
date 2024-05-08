package model;

import java.util.ArrayList;
//Kald alle arraylists
public class Hotel {
    private String navn;
    private String adresse;
    private int singlePris;
    private int doublePris;
    private final ArrayList<Tillæg> tillæg = new ArrayList<>();
    private final ArrayList<Konference> konferencer = new ArrayList<>();
    private final ArrayList<HotelBooking> hotelBookinger = new ArrayList<>();

    public Hotel(String navn, int singlePris, int doublePris) {
        this.navn = navn;
        this.singlePris = singlePris;
        this.doublePris = doublePris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getSinglePris() {
        return singlePris;
    }

    public int getDoublePris() {
        return doublePris;
    }

//    //Assocering til tillæg
//
//
//    public void removeTillæg(Tillæg tillæg) {
//        this.tilægger.remove(tillæg);
//
//    }
//
//    //Assocering til konference
//    public ArrayList<Konference> getKonferencer() {
//        return konferencer;
//    }
//
//    public void addKonference(Konference konference) {
//        if (!this.konferencer.contains(konference)) {
//            this.konferencer.add(konference);
//            konference.addHotel(this);
//        }
//    }
//
//    public void removeKonference(Konference konference) {
//        if (this.konferencer.contains(konference)) {
//            this.konferencer.remove(konference);
//            konference.removeHotel(this);
//        }
//    }
//
//    //Assocering 0..* til 1 til hotelværelse
//    public ArrayList<HotelBooking> getHotelVærelser() {
//        return new Arraylist<>(hotelVærelser);
//    }
//
    public ArrayList<Konference> getKonferencer() {
        return konferencer;
    }

    public ArrayList<HotelBooking> getHotelBookinger() {
        return hotelBookinger;
    }

    public void addHotelBooking(HotelBooking hotelBooking){
        this.hotelBookinger.add(hotelBooking);
    }

    //Assocering til tillæg
    public ArrayList<Tillæg> getTillæg() {
        return this.tillæg;
    }

    public void addTillæg(Tillæg tillæg){
        this.tillæg.add(tillæg);
    }

    @Override
    public String toString() {
        return getNavn();
    }
    
}