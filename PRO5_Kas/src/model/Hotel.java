package model;

import java.util.ArrayList;
//Kald alle arraylists
public class Hotel {
    private String name;
    private String adresse;
    private int singlePris;
    private int doublePris;
    private final ArrayList<Tillæg> tilægger = new ArrayList<>();
    private final ArrayList<Konference> konferencer = new ArrayList<>();
    private final ArrayList<HotelBooking> hotelVærelser = new ArrayList<>();

    public Hotel(String name, int singlePris, int doublePris) {
        this.name = name;
        this.singlePris = singlePris;
        this.doublePris = doublePris;
    }

    public String getName() {
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

<<<<<<< Updated upstream
//    //Assocering til tillæg
//    public ArrayList<Tillæg> getTilægger() {
//        return tilægger;
//    }
//
//    public Tillæg createTillæg(String navn, int pris) {
//        Tillæg tillæg = new Tillæg(navn, pris);
//        this.tilægger.add(tillæg);
//        return tillæg;
//    }
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
=======
    public ArrayList<Konference> getKonferencer() {
        return konferencer;
    }

    public ArrayList<HotelVærelse> getHotelVærelser() {
        return hotelVærelser;
    }

    //Assocering til tillæg
    public ArrayList<Tillæg> getTilægger() {
        return tilægger;
    }

>>>>>>> Stashed changes
}