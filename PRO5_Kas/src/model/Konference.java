package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String adresse;
    private int konferenceAfgift;
    private LocalDate startDato;
    private LocalDate slutDate;
    private final ArrayList <Registration> registrationer = new ArrayList<>();
    private final ArrayList <Hotel> hoteller = new ArrayList<>();
    private final ArrayList <Udflugt> udflugter = new ArrayList<>();

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
//____Registration
        public void addRegistration (Registration registration){
            if(!this.registrationer.contains(registration)){
                this.registrationer.add(registration);
                registration.setkonference(this);
            }
        }
        public void removeRegistration (Registration registration){
            if(this.registrationer.contains(registration)){
                this.registrationer.remove(registration);
                registration.setkonference(null);
            }
        }
        public ArrayList<Registration> getRegistrationer () {
            return new ArrayList<>(registrationer);
        }
        //_____Hotel
        public void addHotel(Hotel hotel){
        if(!this.hoteller.contains(hotel)){
            this.hoteller.add(hotel);
           // hotel.addKonference(this);
        }
        }
        public void addHoteller(Hotel...hoteller){
        for(Hotel hotel : hoteller){
            if(!this.hoteller.contains(hotel)){
                this.hoteller.add(hotel);
                //hotel.addKonference(this);
            }
        }
        }
        public void removeHotel(Hotel hotel){
        if(this.hoteller.contains(hotel)){
            this.hoteller.remove(hotel);
            //hotel.removeKonference(this);
        }
        }
        public ArrayList<Hotel> getHoteller(){
        return new ArrayList<>(this.hoteller);
        }
        //____________Udflugt
        public void addUdflugt(Udflugt udflugt){
        if(!this.udflugter.contains(udflugt)){
            this.udflugter.add(udflugt);
        }
        }
        public void addUdflugter(Udflugt...udflugter){
        for(Udflugt udflugt : udflugter){
            if(!this.udflugter.contains(udflugt)){
                this.udflugter.add(udflugt);
            }
        }
        }
        public void removeUdflugt(Udflugt udflugt){
        this.udflugter.remove(udflugt);
        }
        public ArrayList<Udflugt> getUdflugter(){
        return new ArrayList<>(this.udflugter);
        }
        //To String metode
    public String ToString(){
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/mm og HH:mm");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-yyyy @ HH:mm");
        return String.format("%s konference.%n%s - %s på %s.%nTilmeldingsfrist: %s%nDagspris: %d", this.navn, this.startDato, this.slutDate, this.adresse, this.konferenceAfgift);


    }


    }



