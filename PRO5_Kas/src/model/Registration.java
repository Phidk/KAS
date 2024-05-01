package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Registration {
    private String firmaTlfNr;
    private String firmaNavn;
    private LocalDate ankomstDato;
    private LocalDate afstedsDato;
    boolean foredragsholder;
    private Hotelværelse hotelværelse;
    private Deltager deltager;
    private Konference konference;
    private Ledsager ledsager;
    private ArrayList<Tillæg> tillægger = new Arraylist<>();

    public Registration(String firmaTlfNr, String firmaNavn, LocalDate ankomstDato, LocalDate afstedsDato, boolean foredragsholder, Hotelværelse hotelværelse, Deltager deltager, Konference konference) {
        this.firmaTlfNr = firmaTlfNr;
        this.firmaNavn = firmaNavn;
        this.ankomstDato = ankomstDato;
        this.afstedsDato = afstedsDato;
        this.foredragsholder = foredragsholder;
        this.hotelværelse = hotelværelse;
        this.deltager = deltager;
        this.setkonference(konference);
        this.ledsager = ledsager;
    }

    public String getFirmaTlfNr() {
        return firmaTlfNr;
    }

    public void setFirmaTlfNr(String firmaTlfNr) {
        this.firmaTlfNr = firmaTlfNr;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }


    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public LocalDate getAfstedsDato() {
        return afstedsDato;
    }

    public void setAfstedsDato(LocalDate afstedsDato) {
        this.afstedsDato = afstedsDato;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }
    //_________________________________________
    //Tilføjer konference til registration
    public void setkonference(Konference konference){
        if(this.konference != konference){
            if(this.konference != null){
                this.konference.removeRegistration(this);
            }
            if(konference != null){
                konference.addRegistration(this);
            }
            this.konference = konference;
        }
    }
    public Konference getKonference() {
        return konference;
    }



    public Hotelværelse getHotelværelse() {
        return hotelværelse;
    }

    public Deltager getDeltager() {
        return deltager;
    }


    public ArrayList<Tillæg> getTillægger() {
        return tillægger;
    }

}
