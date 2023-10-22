package com.gridnine.testing;


import com.gridnine.testing.airFilter.Flight;
import com.gridnine.testing.airFilter.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String textInBold = "\u001B[1m";
        System.out.println(textInBold + "\n__TOTAL FLIGHTS__");

        List<Flight> flightList = FlightBuilder.createFlights();

        for (Flight flight3 : flightList) {
            String str = "" + flight3;
            System.out.println(str);
        }
        System.out.println();


        System.out.println("__FLIGHTS - WAITING TO DEPARTURE__");
        for (Flight flight2 : flightList) {
            if (flight2.waitingForDepartureFlight()) {
                System.out.println(flight2);
            }
        }

        System.out.println("\n__FLIGHTS - EXCLUDES ARRIVAL BEFORE DEPARTURE__");
        for (Flight flight1 : flightList) {
            if (flight1.excludeArrivalBeforeDepartureDate()) {
                System.out.println(flight1);
            }
        }

        System.out.println("\n__FLIGHTS - TOTAL TIME ON THE GROUND EXCEEDS THE PRESCRIBED TIME (2 HOURS)__");
        for (Flight flight : flightList) {
            if (flight.longTimeOnEarth()) {
                System.out.println(flight);
            }
        }
    }
}