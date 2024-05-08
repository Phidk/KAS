package model;


import java.util.ArrayList;

public class Deltager extends Person {

    private String adresse;
    private String land;
    private String by;
    private String tlfNr;
    private final ArrayList<Registration> registrationer = new ArrayList<Registration>();

    public Deltager(String navn, String adresse, String land, String by, String tlfNr) {
        this.adresse = adresse;
        this.navn = navn;
        this.land = land;
        this.by = by;
        this.tlfNr = tlfNr;
    }


    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getLand() {
        return land;
    }

    public String getBy() {
        return by;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public ArrayList<Registration> getRegistrationer() {
        return registrationer;
    }

    public void addRegistration(Registration registration) {
        registrationer.add(registration);
    }
    public void removeRegistration(Registration registration){
        registrationer.remove(registration);
    }

    @Override
    public String toString() {
        return "Deltager{" +
                "navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", land='" + land + '\'' +
                ", by='" + by + '\'' +
                ", tlfNr='" + tlfNr + '\'' +
                ", registrationer=" + registrationer.size() +
                '}';
    }
    //Metode til at navnene kommer i alfabetisk rækkefølge
    public int compareTo(Deltager other){
        return this.navn.compareTo(other.navn);
    }
}
