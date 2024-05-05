package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {

    private String navn;
    private String destination;
    private LocalDate dato;
    private int pris;
    private boolean frokost;

    private ArrayList<Ledsager> ledsagere = new ArrayList<>();

    // Setup association to Ledsager

    public Udflugt(String destination, LocalDate dato, int pris, Boolean frokost, Konference konference) {
        this.destination = destination;
        this.dato = dato;
        this.pris = pris;
        this.frokost = frokost;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

   //Boolean om frokost er inkluderet
    public boolean frokost(){
        return this.frokost();
    }
    public void setFrokost(boolean frokost) {
        this.frokost = frokost;
    }

    public ArrayList<Ledsager> getLedsagere(){
        return new ArrayList<>(ledsagere);
    }
    public void addLedsager(Ledsager ledsager){
        ledsagere.add(ledsager);
    }
    public void removeLedsager(Ledsager ledsager){
        ledsagere.remove(ledsager);
    }
}
