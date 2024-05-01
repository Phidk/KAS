package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {

    private String navn;
    private String destination;
    private LocalDate dato;
    private LocalDateTime tid;
    private int pris;
    private Boolean frokost;
    // Setup association to Ledsager
    // private ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Udflugt(String navn, String destination, LocalDate dato, LocalDateTime tid, int pris, Boolean frokost) {
        this.navn = navn;
        this.destination = destination;
        this.dato = dato;
        this.tid = tid;
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

    public LocalDateTime getTid() {
        return tid;
    }

    public void setTid(LocalDateTime tid) {
        this.tid = tid;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public Boolean getFrokost() {
        return frokost;
    }

    public void setFrokost(Boolean frokost) {
        this.frokost = frokost;
    }
}
