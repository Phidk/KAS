package gui;

import model.*;
import controller.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class KasTest {
    public static void main(String[] args) {
        Deltager deltager1 = Controller.createDeltager("Finn Madsen", "Broloftet 11", "Danmark", "Aarhus", "23888571");
        Deltager deltager2 = Controller.createDeltager("Niels Petersen", "Bæltevej 13", "Danmark", "Aarhus", "31348571");
        Deltager deltager3 = Controller.createDeltager("Ulla Hansen", "Kirkegade 15", "Danmark", "Aarhus", "12341234");
        Deltager deltager4 = Controller.createDeltager("Peter Sommer", "Gågadevej 4", "Danmark", "Aarhus", "43214321");
        Deltager deltager5 = Controller.createDeltager("Lone Jensen", "Piftervej 7", "Danmark", "Aarhus", "67896789");

        ArrayList<Deltager> deltagere = new ArrayList<>();
        deltagere.add(deltager1);
        deltagere.add(deltager2);
        deltagere.add(deltager3);
        deltagere.add(deltager4);
        deltagere.add(deltager5);

        Konference.selectionSort(deltagere);

        System.out.println("Sorted with selection sort:");
        for (Deltager deltager : deltagere) {
            System.out.println(deltager);
        }

        // Create konference 'Hav og Himmel' som kører fra  18/5 to 20/5 2024 ved Odense Universitet med  1500kr daglig afgift
        Konference konference1 = Controller.createKonference("Hav og Himmel", "Odense Universitet", 1500, LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20));
        // Create udflugter
        Udflugt udflugt1 = Controller.createUdflugt("Byrundtur, Odense", LocalDate.of(2024, 5, 18), 125, true, konference1);
        Udflugt udflugt2 = Controller.createUdflugt("Egeskov", LocalDate.of(2024, 5, 19), 75, false, konference1);
        Udflugt udflugt3 = Controller.createUdflugt("Trapholt Museum, Kolding", LocalDate.of(2024, 5, 20), 200, false, konference1);

        // Create af hoteller og tillæg
        Hotel hotel1 = Controller.createHotel("Den Hvide Svane", 1050, 1250);
        Tillæg tillæg1 = Controller.createTillæg("WiFi", 50, hotel1);

        Hotel hotel2 = Controller.createHotel("Hotel Phønix", 700, 800);
        Tillæg tillæg2 = Controller.createTillæg("Bad", 200, hotel2);
        Tillæg tillæg3 = Controller.createTillæg("WiFi", 75, hotel2);

        Hotel hotel3 = Controller.createHotel("Pension Tusindfryd", 500, 600);
        Tillæg tillæg4 = Controller.createTillæg("Morgenmad", 100, hotel2);

        // Tilføjer hoteller til konferencen
        Controller.addHotelToKonference(hotel1, konference1);
        Controller.addHotelToKonference(hotel2, konference1);
        Controller.addHotelToKonference(hotel3, konference1);

        // Registration for Finn alle 3 dage af konference1
        Registration registration1 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager1, konference1);

        // Registration for Niels alle 3 dage af konference1
        Registration registration2 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager2, konference1);
        // Niels skal til hotelværelse på hotel "Den hvide svane" uden tillæg
        HotelBooking hotelBooking1 = Controller.createHotelVærelse(1, hotel1.getSinglePris(), EnumVærelser.Værelser.SINGLE, hotel1);
        Controller.setHotelVærelseOfRegistration(registration2, hotelBooking1);

        // Registration for Ulla for første 2 dage af konference1
        Registration registration3 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 19), false, deltager3, konference1);
        Ledsager ledsager1 = Controller.createLedsager("Hans Hansen", registration3);
        Controller.addUdflugtToLedsager(ledsager1, udflugt1);

        // Registration for Peter alle 3 dage af konference1
        Registration registration4 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), false, deltager4, konference1);
        Ledsager ledsager2 = Controller.createLedsager("Mie Sommer", registration4);
        Controller.addUdflugtToLedsager(ledsager2, udflugt2);
        Controller.addUdflugtToLedsager(ledsager2, udflugt3);
        // Peter skal til hotelværelse på "Den hvide svane" med tilvalgt wifi.
        HotelBooking hotelBooking2 = Controller.createHotelVærelse(2, hotel1.getDoublePris(), EnumVærelser.Værelser.DOUBLE, hotel1);
        Controller.setHotelVærelseOfRegistration (registration4, hotelBooking2);
        Controller.addTillægToHotelVærelse(hotelBooking2, tillæg1);

        // Registration for Lone alle 3 dage af konference1
        Registration registration5 = Controller.createRegistration("", "", LocalDate.of(2024, 5, 18), LocalDate.of(2024, 5, 20), true, deltager5, konference1);
        Ledsager ledsager3 = Controller.createLedsager("Jan Madsen", registration5);
        Controller.addUdflugtToLedsager(ledsager3, udflugt1);
        Controller.addUdflugtToLedsager(ledsager3, udflugt2);
        // Lone skal på hotel "Den hvide svane" med tilvagt wifi.
        HotelBooking hotelBooking3 = Controller.createHotelVærelse(3, hotel1.getDoublePris(), EnumVærelser.Værelser.DOUBLE, hotel1);
        Controller.setHotelVærelseOfRegistration(registration5, hotelBooking3);
        Controller.addTillægToHotelVærelse(hotelBooking3, tillæg1);

        System.out.println();
        for (Konference konference : Controller.getKonferencer()) {
            System.out.println("Konference created: " + konference.getNavn());
        }
        System.out.println();

        for (Hotel hotel : Controller.getHoteller()) {
            System.out.print("Hotel created: " + hotel.getNavn() + " med tillæg: ");
            for (Tillæg tillæg : hotel.getTillæg()) {
                System.out.print(tillæg.getName() + ", ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Number of deltagere: " + Controller.getDeltager().size());
        System.out.println(konference1.listParticipantsForKonference());
        System.out.println();

        for (Deltager deltager : Controller.getDeltager()) {
            System.out.println("Registration details for: " + deltager.getNavn());
            for (Registration registration : deltager.getRegistrationer()) {
                System.out.println("Konference: " + registration.getKonference().getNavn());
                System.out.println("Ankomst Dato: " + registration.getAnkomstDato());
                System.out.println("Afskeds Dato: " + registration.getAfstedsDato());
                System.out.println("Foredragsholder: " + registration.isForedragsholder());
                if (registration.getHotelVærelse() != null) {
                    System.out.println("Hotel: " + registration.getHotelVærelse().getHotel().getNavn());
                    System.out.println("Værelse Nummer: " + registration.getHotelVærelse().getNummer());
                    System.out.println("Værelse Pris: " + registration.getHotelVærelse().calculateVærelsesPris());
                }
                if (registration.getLedsager() != null) {
                    System.out.println("Ledsager: " + registration.getLedsager().getNavn());
                    System.out.println("Udflugter:");
                    for (Udflugt udflugt : registration.getLedsager().getUdflugter()) {
                        System.out.println("- " + udflugt.getDestination() + " on " + udflugt.getDato() + " with price " + udflugt.getPris());
                    }
                }
                System.out.println("Total Price: " + registration.calculateTotalPris());
                System.out.println("--------------------------------------");
            }
        }
    }
}

