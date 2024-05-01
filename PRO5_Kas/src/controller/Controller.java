package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Controller {
    public static void init () {
        Controller.initStorage();
    }

    private static void initStorage () {

    }
    // ----------------------------- Konferencer -----------------------------
    public static Konference createKonference(String navn, String adresse, int konferenceAfgift, LocalDate startDato, LocalDate slutDato) {
        Konference konference = new Konference(navn, adresse, konferenceAfgift, startDato, slutDato);
        Storage.addKonference(konference);
        return konference;
    }

    public static void removeKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    public static ArrayList<Conference> getConferences () {
        return Storage.getConferences();
    }

    // ----------------------------- Hoteller -----------------------------
    public static Hotel createHotel(String navn, String adresse, int singlePris, int doublePris) {
        Hotel hotel = new Hotel(navn, adresse, singlePris, doublePris);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static void removeHotel(Hotel hotel) {
         Storage.removeHotel(hotel);
    }

    public static ArrayList<Hotel> getHotels() {
         return Storage.getHotels();
    }

    // ----------------------------- Udflugter -----------------------------
    public static Udflugt createUdflugt(String navn, String destination, LocalDate dato, LocalDateTime tid, int pris, Boolean frokost) {
         Udflugt udflugt = new Udflugt(navn, destination, dato, tid, pris, frokost);
         Storage.addUdflugt(udflugt);
         return udflugt;
    }

    public static void removeUdflugt(Udflugt udflugt) {
         Storage.removeUdflugt(udflugt);
    }

    public static ArrayList<Udflugt> getUdflugter() {
         return Storage.getUdflugter();
    }

    // ----------------------------- Deltagere -----------------------------
    public static Deltager createDeltager(String navn, Boolean foredragsholder, String adresse, String land, String by, String tlfNr) {
        Deltager deltager = new Deltager(navn, foredragsholder, adresse, land, by, tlfNr);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void removeDeltager(Deltager deltager) {
        Storage.removeDeltager(deltager);
    }

    public static ArrayList<Deltager> getDeltager() {
        return Storage.getDeltagere();
    }

    // ----------------------------- Registreringer -----------------------------
    public void createRegistration(String firmaTlfNr, String firmaNavn, LocalDate ankomstDato, LocalDate afskedsdato, Deltager deltager, Konference konference) {
    }


}

