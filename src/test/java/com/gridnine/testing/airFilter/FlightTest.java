package com.gridnine.testing.airFilter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @org.junit.jupiter.api.Test
    void waitingForDepartureFlightTest() {
        List<Segment> seg = new ArrayList<>();
        seg.add(new Segment(LocalDateTime.of(2023, 10, 25, 11, 11), LocalDateTime.of(2023, 10, 25, 22, 22)));
        Flight flight = new Flight(seg);
        assertTrue(flight.waitingForDepartureFlight());
    }

    @org.junit.jupiter.api.Test
    void excludeArrivalBeforeDepartureDateTest() {
        List<Segment> seg = new ArrayList<>();
        seg.add(new Segment(LocalDateTime.of(2023, 10, 22, 11, 11), LocalDateTime.of(2023, 10, 25, 22, 22)));
        Flight flight = new Flight(seg);
        assertTrue(flight.excludeArrivalBeforeDepartureDate());
    }

    @org.junit.jupiter.api.Test
    void longTimeOnEarthTest() {
        List<Segment> segs = new ArrayList<>();
        segs.add(new Segment(LocalDateTime.of(2023, 10, 25, 11, 11), LocalDateTime.of(2023, 10, 25, 15, 15)));
        segs.add(new Segment(LocalDateTime.of(2023, 10, 25, 20, 20), LocalDateTime.of(2023, 10, 25, 23, 23)));
        Flight flight = new Flight(segs);
        assertTrue(flight.longTimeOnEarth());
    }
}