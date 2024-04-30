package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String adresse;
    private int konferenceAfgift;
    private LocalDate startDato;
    private LocalDate slutDate;
    //private final ArrayList <Registration> registrationer = new Arraylist<>();
    //private final Arraylist <Hotel> hoteller = new Arraylist<>();
    //private final Arraylist <Udflugt> udflugter = new Arraylist<>();

    public Konference(String navn, String adresse, int konferenceAfgift, LocalDate startDato, LocalDate slutDate, Registration registration) {
        this.navn = navn;
        this.adresse = adresse;
        this.konferenceAfgift = konferenceAfgift;
        this.startDato = startDato;
        this.slutDate = slutDate;
        //this.registration = registration;
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

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDate() {
        return slutDate;
    }
//    public Registration getRegistration(){
//        return registration;
//    }
//    public void setRegistration(){
//        this.registration = registration;
//    }
    public Arraylist<Registration> getRegistration(){
        return new ArrayList<>(registrationer);
    }
    public void addRegistration(Registration registration){
        registrationer.add(registration);
    }
    public void removeRegistration(Registration registration){
        registrationer.remove(registration);
    }
    

}
