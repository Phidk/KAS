package gui;

import model.*;
import storage.*;
import controller.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class KasTest {
    public static void main(String[] args) {
        Deltager deltager1 = new Deltager("Finn Madsen", "Broloftet 11", "Danmark", "Aarhus", "23888571");
        Deltager deltager2 = new Deltager("Niels Petersen", "Bæltevej 13", "Danmark", "Aarhus", "31348571");
        Deltager deltager3 = new Deltager("Ulla Hansen", "Kirkegade 15", "Danmark", "Aarhus", "12341234");
        Deltager deltager4 = new Deltager("Peter Sommer", "Gågadevej 4", "Danmark", "Aarhus", "43214321");
        Deltager deltager5 = new Deltager("Lone Jensen", "Piftervej 7", "Danmark", "Aarhus", "67896789");


        ArrayList<Deltager> deltagere = new ArrayList<>();
        deltagere.add(deltager1);
        deltagere.add(deltager2);
        deltagere.add(deltager3);
        deltagere.add(deltager4);
        deltagere.add(deltager5);


        selectionSort(deltagere);

        System.out.println("Sorted with selection sort:");
        for (Deltager deltager : deltagere) {
            System.out.println(deltager);

        }
        // Create conference 'Hav og Himmel' running from 18/5 to 20/5 2024 at Odense Universitet and 100kr afgift
        Konference konference1 = new Konference("Hav og Himmel", "Odense Universitet", 1500, LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20));

        Udflugt udflugt1 = new Udflugt("Byrundtur, Odense", LocalDate.of(2024, 5, 18), 125, true, konference1);
        Udflugt udflugt2 = new Udflugt("Egeskov", LocalDate.of(2024, 5, 19), 75, false, konference1);
        Udflugt udflugt3 = new Udflugt("Trapholt Museum, Kolding", LocalDate.of(2024, 5, 20), 200, false, konference1);

        Hotel hotel1 = Controller.createHotel("Den Hvide Svane", 1050, 1250);
        Tillæg tillæg1 = Controller.createTillæg("WiFi", 50, hotel1);

        Hotel hotel2 = Controller.createHotel("Hotel Phønix", 700, 800);
        Tillæg tillæg2 = Controller.createTillæg("Bad", 200, hotel2);
        Tillæg tillæg3 = Controller.createTillæg("WiFi", 75, hotel2);

        Hotel hotel3 = Controller.createHotel("Pension Tusindfryd", 500, 600);
        Tillæg tillæg4 = Controller.createTillæg("Morgenmad", 100, hotel2);

        konference1.addHoteller(hotel1, hotel2, hotel3);

        // Registration for Finn all 3 days of konference1
        Registration registration1 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager1, konference1);

        // Registration for Niels all 3 days of konference1
        Registration registration2 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager2, konference1);

        // Registration for Ulla for first 2 days of konference1
        Registration registration3 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 19), false, deltager3, konference1);
        // Ulla's ledsager Hans Hansen who is going to the Byrundtur i Odense

        // Registration for Peter all 3 days of konference1
        Registration registration4 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager4, konference1);
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

