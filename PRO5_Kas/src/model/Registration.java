package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Registration {
    boolean foredragsholder;
    private String firmaTlfNr;
    private String firmaNavn;
    private LocalDate ankomstDato;
    private LocalDate afstedsDato;
    private HotelBooking hotelBooking;
    private Deltager deltager;
    private Konference konference;
    private Ledsager ledsager;
    //private int samletPris;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();

    public Registration(String firmaTlfNr, String firmaNavn, LocalDate ankomstDato, LocalDate afstedsDato, boolean foredragsholder, Deltager deltager, Konference konference) {
        this.firmaTlfNr = firmaTlfNr;
        this.firmaNavn = firmaNavn;
        this.ankomstDato = ankomstDato;
        this.afstedsDato = afstedsDato;
        this.foredragsholder = foredragsholder;
        this.hotelBooking = hotelBooking;
        this.deltager = deltager;
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
 //Controller
    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public Konference getKonference() {
        return konference;
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public HotelBooking getHotelBooking() {
        return hotelBooking;
    }

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        this.ledsager = ledsager;
        return ledsager;
    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    public void addTillæg(Tillæg tillæg) {
        this.tillæg.add(tillæg);
    }

    public void removeTillæg(Tillæg tillæg) {
        this.tillæg.remove(tillæg);
    }

    //Udregner tillægspris
    public double calculateTillægsPris() {
        double sum = 0.0;
        for (Tillæg tillæg : this.tillæg) {
            sum += tillæg.getPris();
        }
        return sum;
    }

    //Udregner den totale pris for opholdet
    //Hvis personen ikke er foredragsholder, skal deltageren betale konferenceafgift
    //Hvis personen har valgt et hotelværelse, udregnes værelse, tillægspris og antal dage
    //Hvis personen deltager i udflugter, udregnes udflugtsprisenn
    public int calculateTotalPris() {
        int totalDage = (int) ChronoUnit.DAYS.between(this.ankomstDato, this.afstedsDato);
        int sum = 0;

        if (!this.isForedragsholder()) {
            sum = this.konference.getKonferenceAfgift() * (totalDage + 1);
        }
        if (this.hotelBooking != null) {
            sum += (this.getHotelVærelse().calculateVærelsesPris() + this.getHotelVærelse().calculateTillægsPris()) * totalDage;
        }
        if (this.ledsager != null) {
            sum += this.ledsager.calculateUdflugtsPris();
        }
        return sum;
    }

    //_________________________________
    public HotelBooking getHotelVærelse() {
        return hotelBooking;
    }

    public void setHotelVærelse(HotelBooking hotelværelse) {
        this.hotelBooking = hotelværelse;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void setHotelBooking(HotelBooking hotelBooking) {
    }

    @Override
    public String toString() {
        return "Registration{" +
                "foredragsholder=" + foredragsholder +
                ", firmaTlfNr='" + firmaTlfNr + '\'' +
                ", firmaNavn='" + firmaNavn + '\'' +
                ", ankomstDato=" + ankomstDato +
                ", afstedsDato=" + afstedsDato +
                ", hotelBooking=" + hotelBooking +
                ", deltager=" + deltager +
                ", konference=" + konference +
                ", ledsager=" + ledsager +
                ", tillæg=" + tillæg +
                '}';
    }
}
