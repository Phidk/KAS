package storage;

import model.*;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();
    private static final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();
    private static final ArrayList<Registration> registrationer = new ArrayList<>();
    private static final ArrayList<Hotelværelse> hotelværelser = new ArrayList<>();
    private static final ArrayList<Tillæg> tillæg = new ArrayList<>();
    private static final ArrayList<Ledsager> ledsagere = new ArrayList<>();

    // ---------------------- Konferencer ----------------------
    public static void addKonference(Konference konference) {
        Storage.konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        Storage.konferencer.remove(konference);
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    // ---------------------- Hoteller ----------------------
    public static void addHotel(Hotel hotel) {
        Storage.hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        Storage.hoteller.remove(hotel);
    }

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    // ---------------------- Udflugter ----------------------
    public static void addUdflugt(Udflugt udflugt) {
        Storage.udflugter.add(udflugt);
    }

    public static void removeUdflugt(Udflugt udflugt) {
        Storage.udflugter.remove(udflugt);
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    // ---------------------- Deltagere ----------------------
    public static void addDeltager(Deltager deltager) {
        Storage.deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        Storage.deltagere.remove(deltager);
    }

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    // ---------------------- Registrationer ----------------------
    public static void addRegistration(Registration registration) {
        Storage.registrationer.add(registration);
    }

    public static void removeRegistration(Registration registration) {
        Storage.registrationer.remove(registration);
    }

    public static ArrayList<Registration> getRegistrationer() {
        return new ArrayList<>(registrationer);
    }

        // ---------------------- HotelVærelser ----------------------
    public static void addHotelværelse(Hotelværelse hotelværelse) {
        Storage.hotelværelser.add(hotelværelse);
    }

    public static void removeHotelværelse(Hotelværelse hotelværelse) {
        Storage.hotelværelser.remove(hotelværelse);
    }

    public static ArrayList<Hotelværelse> getHotelværelser() {
        return new ArrayList<>(hotelværelser);
    }

    // ---------------------- Tillæg ----------------------
    public static void addTillæg(Tillæg tillæg) {
        Storage.tillæg.add(tillæg);
    }

    public static void removeTillæg(Tillæg tillæg) {
        Storage.tillæg.remove(tillæg);
    }

    public static ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    // ---------------------- Ledsager ----------------------
//    public static void addLedsager(Ledsager ledsager) {
//        Storage.ledsagere.add(ledsager);
//    }
//
//    public static void removeLedsager(Ledsager ledsager) {
//        Storage.ledsagere.remove(ledsager);
//    }
//
//    public static ArrayList<Ledsager> getLedsagere() {
//        return new ArrayList<>(ledsagere);
//    }
}
