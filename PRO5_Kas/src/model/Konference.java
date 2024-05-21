package model;

import gui.KasTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String adresse;
    private int konferenceAfgift;
    private LocalDate startDato;
    private LocalDate slutDate;
    private final ArrayList<Registration> registrationer = new ArrayList<>();
    private final ArrayList<Hotel> hoteller = new ArrayList<>();
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Konference(String navn, String adresse, int konferenceAfgift, LocalDate startDato, LocalDate slutDate) {
        this.navn = navn;
        this.adresse = adresse;
        this.konferenceAfgift = konferenceAfgift;
        this.startDato = startDato;
        this.slutDate = slutDate;
    }


    public String getNavn()   {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getKonferenceAfgift() {
        return konferenceAfgift;
    }

    public void setKonferenceAfgift(int konferenceAfgift) {
        this.konferenceAfgift = konferenceAfgift;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public void setSlutDate(LocalDate slutDate) {
        this.slutDate = slutDate;
    }

    public LocalDate getSlutDate() {
        return slutDate;
    }

    /**
     * Returnerer en liste af deltagerne tilhørende en konference
     */
    public ArrayList<String> listParticipantsForKonference() {
        ArrayList<Deltager> deltagere = new ArrayList<>();
        for (Registration registration : this.registrationer) {
            deltagere.add(registration.getDeltager());
        }

        selectionSort(deltagere);

        ArrayList<String> deltageresNavne = new ArrayList<>();
        for (Deltager deltager : deltagere) {
            deltageresNavne.add(deltager.getNavn());
        }

        return deltageresNavne;
    }

    /**
     * Anvendt til at sortere en liste af deltagere
     */
    public static void selectionSort(ArrayList<Deltager> deltagere) {
        for (int i = 0; i < deltagere.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < deltagere.size(); j++) {
                if (deltagere.get(j).compareTo(deltagere.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            Deltager temp = deltagere.get(i);
            deltagere.set(i, deltagere.get(indexOfMin));
            deltagere.set(indexOfMin, temp);
        }
    }

    public void addRegistration(Registration registration){
        registrationer.add(registration);
    }
    public void removeRegistration(Registration registration){
        registrationer.remove(registration);
    }
    public ArrayList<Registration> getRegistrationer() {
        return new ArrayList<>(registrationer);
    }

    //Hotel
    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(this.hoteller);
    }
    // temp change
    public void addHotel(Hotel hotel) {
        this.hoteller.add(hotel);
    }

    public void removeHotel(Hotel hotel) {
        this.hoteller.remove(hotel);
    }
//    public void addHotel (Hotel hotel) {
//        if (!this.hoteller.contains(hotel)) {
//            this.hoteller.add(hotel);
//            hotel.addKonference(this);
//        }
//    }
//
//    public void removeHotel (Hotel hotel) {
//        if (this.hoteller.contains(hotel)) {
//            this.hoteller.remove(hotel);
//            hotel.removeKonference(this);
//        }
//    }

    //Udflugt
    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }
    public void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }

    public void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    @Override
    public String toString() {
        return getNavn();
    }
}



