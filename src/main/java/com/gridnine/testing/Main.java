package com.gridnine.testing;


import com.gridnine.testing.airFilter.Flight;
import com.gridnine.testing.airFilter.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String textInBold = "\u001B[1m";
        System.out.println(textInBold + "\n__TOTAL FLIGHTS__");

        List<Flight> flightList = FlightBuilder.createFlights();

        flightList.stream().map(flight -> "" + flight).forEach(System.out::println);
        System.out.println();


        System.out.println("__FLIGHTS - WAITING TO DEPARTURE__");
        flightList.stream()
                .filter(Flight::waitingForDepartureFlight)
                .forEach(System.out::println);

        System.out.println("\n__FLIGHTS - EXCLUDES ARRIVAL BEFORE DEPARTURE__");
                flightList.stream()
                .filter(Flight::excludeArrivalBeforeDepartureDate)
                .forEach(System.out::println);

        System.out.println("\n__FLIGHTS - TOTAL TIME ON THE GROUND EXCEEDS THE PRESCRIBED TIME (2 HOURS)__");
                flightList.stream()
                .filter(Flight::longTimeOnEarth)
                .forEach(System.out::println);
    }
}