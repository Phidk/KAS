package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
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
    public static Hotel createHotel(String navn, int singlePris, int doublePris) {
        Hotel hotel = new Hotel(navn, singlePris, doublePris);
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
    // Association: Konference 1 --> Udflugt 0..*
    public static Udflugt createUdflugt(String destination, LocalDate dato, int pris, Boolean frokost, Konference konference) {
         Udflugt udflugt = new Udflugt(destination, dato, pris, frokost, konference);
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
    public static Deltager createDeltager(String navn, String adresse, String land, String by, String tlfNr) {
        Deltager deltager = new Deltager(navn, adresse, land, by, tlfNr);
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
    public static Registration createRegistration(String firmaTlfNr, String firmaNavn, LocalDate ankomstDato, LocalDate afskedsdato, boolean foredragsholder, Deltager deltager, Konference konference) {
        var registration = new Registration(firmaTlfNr, firmaNavn, ankomstDato, afskedsdato, foredragsholder, deltager, konference);
        konference.addRegistration(registration);
        deltager.addRegistration(registration);
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

    // ----------------------------- HotelVærelser -----------------------------

    /**
     * Opretter et hotelværelse og gemmer det i storage
     * Pre: værelsesNr > 0 && antalSenge > 0 && pris >= 0
     */
    public static HotelVærelse createHotelVærelse(int værelsesNr, int pris, EnumVærelser.Værelser værelseType, Hotel hotel) {
        HotelVærelse hotelværelse = new HotelVærelse(værelsesNr,pris, værelseType, hotel);
        Storage.addHotelværelse(hotelværelse);
        return hotelværelse;
    }

    /**
     * Sletter et hotelværelse fra storage
     */
    public static void removeHotelVærelse(HotelVærelse hotelværelse) {
        Storage.removeHotelværelse(hotelværelse);
    }

    /**
     * Returnerer en liste af hotelværelser fra storage
     */
    public static ArrayList<HotelVærelse> getHotelværelser() {
        return Storage.getHotelVærelser();
    }

    // ----------------------------- Tillæg -----------------------------

    /**
     * Opretter et tillæg og gemmer det i storage
     * Pre: pris >= 0
     */
    public static Tillæg createTillæg(String navn, double pris, Hotel hotel) {
        Tillæg tillæg = new Tillæg(navn, pris, hotel);
        Storage.addTillæg(tillæg);
        return tillæg;
    }

    /**
     * Sletter et tillæg fra storage
     */
    public static void removeTillæg(Tillæg tillæg) {
        Storage.removeTillæg(tillæg);
    }

    /**
     * Returnerer en liste af tillæg fra storage
     */
    public static ArrayList<Tillæg> getTillæg() {
        return Storage.getTillæg();
    }
    // ----------------------------- Ledsagere -----------------------------
    public static Ledsager createLedsager(String navn, Registration registration) {
        registration.createLedsager(navn);
        return registration.getLedsager();
    }

    public static void removeLedsager(Ledsager ledsager) {
//        Storage.removeLedsager(ledsager);
    }

    public static Ledsager getLedsager(Registration registration) {
        return registration.getLedsager();
    }
}

