package com.gridnine.testing.airFilter;

import com.gridnine.testing.FlightFilter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight implements FlightFilter {

    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean waitingForDepartureFlight() {
        for (Segment segment : segments) {
            if (segment.getDepartureDate()
                    .isAfter(LocalDateTime.now())) {
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean excludeArrivalBeforeDepartureDate() {
        for (Segment segment : segments) {
            if (segment.getDepartureDate()
                    .isBefore(segment.getArrivalDate())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean longTimeOnEarth() {
        long hours = 0;
        for (int i = 1; i < segments.size(); i++) {
            LocalDateTime pastArrival = segments.get(i - 1).getArrivalDate();
            LocalDateTime departureNext = segments.get(i).getDepartureDate();
            long timing = pastArrival.until(departureNext, ChronoUnit.HOURS);
            hours = hours + timing;
        }
        return hours > 2;
    }
}