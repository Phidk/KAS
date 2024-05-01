package model;

import java.util.ArrayList;
//Færdig
public class Ledsager {
    private String navn;
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private Deltager deltager;


    public Ledsager(String navn) {
        this.navn = navn;
    }
    //Assocering 0..* til 0..* til udflugter
    public ArrayList<Udflugt> getUdflugter(){
        return new ArrayList<>(udflugter);
    }
    public void addUdflugter(Udflugt udflugt){
        udflugter.add(udflugt);
    }
    public void removeUdflugt(Udflugt udflugt){
        udflugter.remove(udflugt);
    }
    public double calculateUdflugtsPris(){
        double sum = 0.0;
        for (Udflugt udflugt : this.udflugter){
            sum += udflugt.getPris();
        }
        return sum;
    }
    //______________________________________
}
