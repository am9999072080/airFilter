package com.gridnine.testing.airFilter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Bean that represents a flight segment.
 */
public class Segment {
    private final LocalDateTime departureDate;

    private final LocalDateTime arrivalDate;

    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    public LocalDateTime getDepartureDate() {

        return departureDate;
    }

    LocalDateTime getArrivalDate() {

        return arrivalDate;
    }

    @Override
    public String toString() {
        int i = hashCode() % 100;
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return "FLIGHT_" + i + ":[departure: " + departureDate.format(fmt) + " | arrival: " + arrivalDate.format(fmt)
                + ']';
    }
}