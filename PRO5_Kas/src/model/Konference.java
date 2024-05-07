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

    public String getNavn() {
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

    public ArrayList<String> listUdflugterForKonference() {
        ArrayList<String> udflugtersNavne = new ArrayList<>();
        for (Udflugt udflugt : udflugter) {
            udflugtersNavne.add(udflugt.getDestination());
        }
        return udflugtersNavne;
    }

    public ArrayList<String> listHotellerForKonference() {
        ArrayList<String> hotellersNavne = new ArrayList<>();
        for (Hotel hotel : hoteller) {
            hotellersNavne.add(hotel.getNavn());
        }
        return hotellersNavne;
    }

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


//    public static void selectionSort(ArrayList<Deltager> deltagere) {
//        for (int i = 0; i < deltagere.size() - 1; i++) {
//            int indexOfMin = i;
//            for (int j = i + 1; j < deltagere.size(); j++) {
//                if (deltagere.get(j).compareTo(deltagere.get(indexOfMin)) < 0) {
//                    indexOfMin = j;
//                }
//            }
//            Deltager temp = deltagere.get(i);
//            deltagere.set(i, deltagere.get(indexOfMin));
//            deltagere.set(indexOfMin, temp);
//        }
//    }
//
//    public ArrayList<String> listParticipantsForKonference() {
//        ArrayList<String> deltageresNavne = new ArrayList<String>();
//        for (Registration registration : this.registrationer) {
//            String navn = registration.getDeltager().getNavn();
//            deltageresNavne.add(navn);
//        }
//        return deltageresNavne;
//    }

    //____Registration
    public void addRegistration(Registration registration){
        registrationer.add(registration);
    }
    public void removeRegistration(Registration registration){
        registrationer.remove(registration);
    }
    public ArrayList<Registration> getRegistrationer() {
        return new ArrayList<>(registrationer);
    }
//    public void addRegistration(Registration registration) {
//        if (!this.registrationer.contains(registration)) {
//            this.registrationer.add(registration);
//            registration.setkonference(this);
//        }
//    }
//
//    public void removeRegistration(Registration registration) {
//        if (this.registrationer.contains(registration)) {
//            this.registrationer.remove(registration);
//            registration.setkonference(null);
//        }
//    }


    //Hotel
    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(this.hoteller);
    }
    public void addHotel(Hotel hotel){
        hoteller.add(hotel);
    }
    public void removeHotel(Hotel hotel){
        hoteller.remove(hotel);
    }

    //____________Udflugt
    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(this.udflugter);
    }
    public void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }

    public void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    //    public void addUdflugt(Udflugt udflugt) {
//        if (!this.udflugter.contains(udflugt)) {
//            this.udflugter.add(udflugt);
//        }
//    }
//


    @Override
    public String toString() {
        return getNavn();
    }

    //To String metode
//    public String ToString() {
//        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/mm og HH:mm");
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-yyyy @ HH:mm");
//        return String.format("%s konference.%n%s - %s på %s.%nTilmeldingsfrist: %s%nDagspris: %d", this.navn, this.startDato, this.slutDate, this.adresse, this.konferenceAfgift);
//    }
}



