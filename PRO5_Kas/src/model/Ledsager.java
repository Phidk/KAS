package model;

import java.util.ArrayList;

public class Ledsager extends Person {
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private Deltager deltager;
    public ArrayList<Udflugt> getUdflugter(){
        return new ArrayList<>(udflugter);
    }

    public Ledsager(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }

    public void removeUdflugt(Udflugt udflugt){
        udflugter.remove(udflugt);
    }

    /**
     * Udregner den samlede pris af de udflugter som ledsageren deltager til.
     */
    public double calculateUdflugtsPris(){
        double sum = 0.0;
        for (Udflugt udflugt : this.udflugter){
            sum += udflugt.getPris();
        }
        return sum;
    }
}
