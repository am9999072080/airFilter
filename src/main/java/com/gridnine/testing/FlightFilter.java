package com.gridnine.testing;

public interface FlightFilter {
    /**
     * Показывает в ожидании вылета в настоящее время
     * Currently awaiting departure
     */
    boolean waitingForDepartureFlight();

    /**
     * Исключает рейсы, где прибытие раньше, чем дата вылета
     * Excludes flights where arrival is earlier than departure date
     */
    boolean excludeArrivalBeforeDepartureDate();

    /**
     * Рейсы, где общее время, проведенное на земле, превышает указанное время.
     * Total time on the ground exceeds the specified time.
     */
    boolean longTimeOnEarth();
}
