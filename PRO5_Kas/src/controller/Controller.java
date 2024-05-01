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

    /**
     * Opretter en konference og gemmer den i storage
     * Pre: startDato <= slutDato && konferenceAfgift >= 0
     */
    public static Konference createKonference(String navn, String adresse, int konferenceAfgift, LocalDate startDato, LocalDate slutDato) {
        Konference konference = new Konference(navn, adresse, konferenceAfgift, startDato, slutDato);
        Storage.addKonference(konference);
        return konference;
    }

    /**
     * Fjerner en konference fra storage
     */
    public static void removeKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    /**
     * Returnerer en liste af konferencer fra storage
     */
    public static ArrayList<Konference> getConferences () {
        return Storage.getKonferencer();
    }

    // ----------------------------- Hoteller -----------------------------

    /**
     * Opretter et hotel og gemmer den i storage
     * Pre: singlePris >= 0 && doublePris >= 0
     */
    public static Hotel createHotel(String navn, String adresse, int singlePris, int doublePris) {
        Hotel hotel = new Hotel(navn, adresse, singlePris, doublePris);
        Storage.addHotel(hotel);
        return hotel;
    }

    /**
     * Fjerner et hotel fra storage
     */
    public static void removeHotel(Hotel hotel) {
         Storage.removeHotel(hotel);
    }

    /**
     * Returnerer en liste af hoteller fra storage
     */
    public static ArrayList<Hotel> getHoteller() {
         return Storage.getHoteller();
    }

    // ----------------------------- Udflugter -----------------------------

    /**
     * Opretter en udflugt og tilføjer den til storage
     * Pre: Pris >= 0
     */
    public static Udflugt createUdflugt(String navn, String destination, LocalDate dato, LocalDateTime tid, int pris, Boolean frokost) {
         Udflugt udflugt = new Udflugt(navn, destination, dato, tid, pris, frokost);
         Storage.addUdflugt(udflugt);
         return udflugt;
    }

    /**
     * Fjerner en udflugt fra storage
     */
    public static void removeUdflugt(Udflugt udflugt) {
         Storage.removeUdflugt(udflugt);
    }

    /**
     * Returnerer en liste af udflugter fra storage
     */
    public static ArrayList<Udflugt> getUdflugter() {
         return Storage.getUdflugter();
    }

    // ----------------------------- Deltagere -----------------------------

    /**
     * Opretter en deltager og tilføjer den til storage
     * Pre: none
     */
    public static Deltager createDeltager(String navn, Boolean foredragsholder, String adresse, String land, String by, String tlfNr) {
        Deltager deltager = new Deltager(navn, foredragsholder, adresse, land, by, tlfNr);
        Storage.addDeltager(deltager);
        return deltager;
    }

    /**
     * Fjerner en deltager fra storage
     */
    public static void removeDeltager(Deltager deltager) {
        Storage.removeDeltager(deltager);
    }

    /**
     * Returnerer en liste af deltagere fra storage
     */
    public static ArrayList<Deltager> getDeltager() {
        return Storage.getDeltagere();
    }

    // ----------------------------- Registreringer -----------------------------

    /**
     * Opretter en registrering og gemmer den i storage
     * Pre: ankomstDato >= afrejseDato && ankomstDato <= konference.getSlutDato() && afrejseDato >= konference.getStartDato()
     */
    public static Registration createRegistration(String firmaTlfNr, String firmaNavn, LocalDate ankomstDato, LocalDate afskedsdato, Deltager deltager, Konference konference) {
        Registration registration = new Registration(firmaTlfNr, firmaNavn, ankomstDato, afskedsdato, deltager, konference);
        Storage.addRegistration(registration);
        return registration;
    }

    /**
     * Sletter en registrering fra storage
     */
    public static void removeRegistration(Registration registration) {
        Storage.removeRegistration(registration);
    }

    /**
     * Returnerer en liste af registrationer fra storage
     */
    public static ArrayList<Registration> getRegistrationer() {
        return Storage.getRegistrationer();
    }

//    // ----------------------------- Tillæg -----------------------------
//    public static Tillæg createTillæg(String navn, double pris) {
//        Tillæg tillæg = new Tillæg(navn, pris);
//        Storage.addTillæg(tillæg);
//        return tillæg;
//    }
//
//    public static void removeTillæg(Tillæg tillæg) {
//        Storage.removeTillæg(tillæg);
//    }
//
//    public static ArrayList<Tillæg> getTillæg() {
//        return Storage.getTillæg();
//    }
//    // ----------------------------- Ledsagere -----------------------------
//    public static Ledsager createLedsager(String navn, int alder, String tlfNr) {
//        Ledsager ledsager = new Ledsager(navn, alder, tlfNr);
//        Storage.addLedsager(ledsager);
//        return ledsager;
//    }
//
//    public static void removeLedsager(Ledsager ledsager) {
//        Storage.removeLedsager(ledsager);
//    }
//
//    public static ArrayList<Ledsager> getLedsagere() {
//        return Storage.getLedsagere();
//    }
//
//    // ----------------------------- HotelVærelser -----------------------------
//    public static HotelVærelse createHotelVærelse(int værelsesNr, int antalSenge, int pris) {
//        HotelVærelse hotelVærelse = new HotelVærelse(værelsesNr, antalSenge, pris);
//        Storage.addHotelVærelse(hotelVærelse);
//        return hotelVærelse;
//    }
//
//    public static void removeHotelVærelse(HotelVærelse hotelVærelse) {
//        Storage.removeHotelVærelse(hotelVærelse);
//    }
//
//    public static ArrayList<HotelVærelse> getHotelVærelser() {
//        return Storage.getHotelVærelser();
//    }
}

