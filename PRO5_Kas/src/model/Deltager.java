package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Deltager extends Person {


    private String adresse;

    boolean foredragsholder;

    private String land;

    private String by;

    private String tlfNr;

    private final ArrayList<Registration> registrationer = new ArrayList<Registration>();

    public Deltager(String navn, String adresse, boolean foredragsholder, String land, String by, String tlfNr) {
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

  public boolean isForedragsholder() {
     return foredragsholder;
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


    @Override
    public String toString() {
        return "Deltager{" +
                "navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", foredragsholder=" + //foredragsholder +
                ", land='" + land + '\'' +
                ", by='" + by + '\'' +
                ", tlfNr='" + tlfNr + '\'' +
                ", registrationer=" + registrationer +
                '}';
    }
}
