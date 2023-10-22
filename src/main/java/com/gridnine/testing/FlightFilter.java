package com.gridnine.testing;

public interface FlightFilter {
    /**
     * Currently awaiting departure
     */
    boolean waitingForDepartureFlight();

    /**
     * Excludes flights where arrival is earlier than departure date
     */
    boolean excludeArrivalBeforeDepartureDate();

    /**
     * Total time on the ground exceeds the specified time.
     */
    boolean longTimeOnEarth();
}
