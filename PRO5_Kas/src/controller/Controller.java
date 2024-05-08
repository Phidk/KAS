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
        // Create de 5 deltagere fra testdata
        Deltager deltager1 = Controller.createDeltager("Finn Madsen", "Broloftet 11", "Danmark", "Aarhus", "23888571");
        Deltager deltager2 = Controller.createDeltager("Niels Petersen", "Bæltevej 13", "Danmark", "Aarhus", "31348571");
        Deltager deltager3 = Controller.createDeltager("Ulla Hansen", "Kirkegade 15", "Danmark", "Aarhus", "12341234");
        Deltager deltager4 = Controller.createDeltager("Peter Sommer", "Gågadevej 4", "Danmark", "Aarhus", "43214321");
        Deltager deltager5 = Controller.createDeltager("Lone Jensen", "Piftervej 7", "Danmark", "Aarhus", "67896789");

        // Create konference 'Hav og Himmel' som kører fra  18/5 to 20/5 2024 ved Odense Universitet med  1500kr daglig afgift
        Konference konference1 = Controller.createKonference("Hav og Himmel", "Odense Universitet", 1500, LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20));

        // Create udflugter
        Udflugt udflugt1 = Controller.createUdflugt("Byrundtur, Odense", LocalDate.of(2024, 5, 18), 125, true, konference1);
        Udflugt udflugt2 = Controller.createUdflugt("Egeskov", LocalDate.of(2024, 5, 19), 75, false, konference1);
        Udflugt udflugt3 = Controller.createUdflugt("Trapholt Museum, Kolding", LocalDate.of(2024, 5, 20), 200, false, konference1);

        // Create af hoteller og tillæg
        Hotel hotel1 = Controller.createHotel("Den Hvide Svane", 1050, 1250);
        Tillæg tillæg1 = Controller.createTillæg("WiFi", 50, hotel1);

        Hotel hotel2 = Controller.createHotel("Hotel Phønix", 700, 800);
        Tillæg tillæg2 = Controller.createTillæg("Bad", 200, hotel2);
        Tillæg tillæg3 = Controller.createTillæg("WiFi", 75, hotel2);

        Hotel hotel3 = Controller.createHotel("Pension Tusindfryd", 500, 600);
        Tillæg tillæg4 = Controller.createTillæg("Morgenmad", 100, hotel2);

        // Tilføjer hoteller til konferencen
        Controller.addHotelToKonference(hotel1, konference1);
        Controller.addHotelToKonference(hotel2, konference1);
        Controller.addHotelToKonference(hotel3, konference1);

        // Registration for Finn alle 3 dage af konference1
        Registration registration1 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager1, konference1);

        // Registration for Niels alle 3 dage af konference1
        Registration registration2 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager2, konference1);
        // Niels skal til hotelværelse på hotel "Den hvide svane" uden tillæg
        HotelBooking hotelBooking1 = Controller.createHotelBooking(1, hotel1.getSinglePris(), EnumVærelser.Værelser.SINGLE, hotel1);
        Controller.setHotelBookingOfRegistration(registration2, hotelBooking1);

        // Registration for Ulla for første 2 dage af konference1
        Registration registration3 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 19), false, deltager3, konference1);
        Ledsager ledsager1 = Controller.createLedsager("Hans Hansen", registration3);
        Controller.addUdflugtToLedsager(ledsager1, udflugt1);

        // Registration for Peter alle 3 dage af konference1
        Registration registration4 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager4, konference1);
        Ledsager ledsager2 = Controller.createLedsager("Mie Sommer", registration4);
        Controller.addUdflugtToLedsager(ledsager2, udflugt2);
        Controller.addUdflugtToLedsager(ledsager2, udflugt3);
        // Peter skal til hotelværelse på "Den hvide svane" med tilvalgt wifi.
        HotelBooking hotelBooking2 = Controller.createHotelBooking(2, hotel1.getDoublePris(), EnumVærelser.Værelser.DOUBLE, hotel1);
        Controller.setHotelBookingOfRegistration(registration4, hotelBooking2);
        Controller.addTillægToHotelBooking(hotelBooking2, tillæg1);

        // Registration for Lone alle 3 dage af konference1
        Registration registration5 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), true, deltager5, konference1);
        Ledsager ledsager3 = Controller.createLedsager("Jan Madsen", registration5);
        Controller.addUdflugtToLedsager(ledsager3, udflugt1);
        Controller.addUdflugtToLedsager(ledsager3, udflugt2);
        // Lone skal på hotel "Den hvide svane" med tilvagt wifi.
        HotelBooking hotelBooking3 = Controller.createHotelBooking(3, hotel1.getDoublePris(), EnumVærelser.Værelser.DOUBLE, hotel1);
        Controller.setHotelBookingOfRegistration(registration5, hotelBooking3);
        Controller.addTillægToHotelBooking(hotelBooking3, tillæg1);
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
    public static ArrayList<Konference> getKonferencer () {
        return Storage.getKonferencer();
    }

    /**
     * Tilføjer konference til registration, fjerner tidligere tilsat konference fra registreringen
     */
    public static void addKonferenceToRegistration(Konference konference, Registration registration) {
        if (registration.getKonference() != konference) {
            Konference oldKonference = registration.getKonference();
            if (oldKonference != null) {
                oldKonference.removeRegistration(registration);
            }
            if (konference != null) {
                konference.addRegistration(registration);
            }
            registration.setKonference(konference);
        }
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

    public static void addHotelToKonference(Hotel hotel, Konference konference) {
        konference.addHotel(hotel);
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
     * Pre: Dato er efter konferencens startdato
     */
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
        registration.setKonference(konference);
        konference.addRegistration(registration);
        deltager.addRegistration(registration);
        Storage.addRegistration(registration);
        return registration;
    }

    /**
     * Sætter hotelværelse på en registrering
     * Pre: Hotelværelse må ikke allerede være optaget
     */
    public static void setHotelBookingOfRegistration(Registration registration, HotelBooking hotelBooking) {
        registration.setHotelVærelse(hotelBooking);
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
    public static HotelBooking createHotelBooking(int værelsesNr, int pris, EnumVærelser.Værelser værelseType, Hotel hotel) {
        HotelBooking hotelBooking = new HotelBooking(værelsesNr, pris, værelseType, hotel);
        hotel.addHotelBooking(hotelBooking);
        Storage.addHotelværelse(hotelBooking);
        return hotelBooking;
    }

    /**
     * Sletter et hotelværelse fra storage
     */
    public static void removeHotelBooking(HotelBooking hotelværelse) {
        Storage.removeHotelværelse(hotelværelse);
    }


    /**
     * Returnerer en liste af hotelværelser fra storage
     */
    public static Hotel getHotelBookinger() {
        return Storage.getHotelVærelser();
    }

    // ----------------------------- Tillæg -----------------------------

    /**
     * Opretter et tillæg og gemmer det i storage
     * Pre: pris >= 0
     */
    public static Tillæg createTillæg(String navn, double pris, Hotel hotel) {
        Tillæg tillæg = new Tillæg(navn, pris, hotel);
        hotel.addTillæg(tillæg);
        Storage.addTillæg(tillæg);
        return tillæg;
    }

    /**
     * Tilføjer et tillæg til et hotelværelse
     */
    public static void addTillægToHotelBooking(HotelBooking hotelBooking, Tillæg tillæg) {
        hotelBooking.addTillæg(tillæg);
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

    /**
     * Opretter en ledsager og tilføjer den til en registration
     */

    public static Ledsager createLedsager(String navn, Registration registration) {
        registration.createLedsager(navn);
        return registration.getLedsager();
    }

    /**
     * Tilføjer en udflugt til en ledsager
     * Pre: Ledsageren må ikke have udflugten i forvejen
     */
    public static void addUdflugtToLedsager(Ledsager ledsager, Udflugt udflugt) {
        ledsager.addUdflugt(udflugt);
    }

    public static void removeLedsager(Registration registration) {
        registration.setLedsager(null);
    }

    /**
     * Returnerer tilsatte ledsager fra en registration
     * Pre: Registration skal have en ledsager
     */
    public static Ledsager getLedsager(Registration registration) {
        return registration.getLedsager();
    }
}

