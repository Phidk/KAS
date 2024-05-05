package gui;

import model.*;
import storage.*;
import controller.*;

import java.util.ArrayList;

public class KasTest {
    public static void main(String[] args) {
        Deltager deltager1 = new Deltager("Finn Madsen", "Broloftet 11", false, "Danmark", "Aarhus", "23888571");
        Deltager deltager2 = new Deltager("Niels Petersen", "Bæltevej 13", true, "Danmark", "Aarhus", "31348571");

        ArrayList<Deltager> deltagere = new ArrayList<>();
        deltagere.add(deltager1);
        deltagere.add(deltager2);

        selectionSort(deltagere);

        System.out.println("Sorted with selection sort:");
        for (Deltager deltager : deltagere) {
            System.out.println(deltager);
        }
    }

    public static void selectionSort(ArrayList<Deltager> deltagere) {
        for (int i = 0; i < deltagere.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < deltagere.size(); j++) {
                if (deltagere.get(j).compareTo(deltagere.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            Deltager temp = deltagere.get(i);
            deltagere.set(i, deltagere.get(indexOfMin));
            deltagere.set(indexOfMin, temp);
        }
    }
}

