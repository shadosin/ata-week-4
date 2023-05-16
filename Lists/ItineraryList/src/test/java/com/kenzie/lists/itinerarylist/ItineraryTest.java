package com.kenzie.lists.itinerarylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ItineraryTest {
    @Test
    public void getNumberOfDestinations_fromEmptyItinerary_numberOfDestinationsIsZero() {
        // GIVEN
        Itinerary itinerary = new Itinerary();

        // WHEN
        int numberOfDestinations = itinerary.getNumberOfDestinations();

        // THEN
        Assertions.assertEquals(0, numberOfDestinations);
    }

    @Test
    public void addDestination_singleDestination_matchingDestinationAdded() {
        // GIVEN
        Itinerary itinerary = new Itinerary();
        Destination destination = new Destination("Seattle", 1);

        // WHEN
        itinerary.addDestination(destination);

        // THEN
        Assertions.assertEquals(1, itinerary.getNumberOfDestinations());
        Assertions.assertEquals("Seattle", itinerary.getDestination(0).getLocation());
        Assertions.assertEquals(1, itinerary.getDestination(0).getDaysAtLocation());
    }

    @Test
    public void addDestination_multipleDestinations_allMatchingDestinationsAddedInCorrectOrder() {
        // GIVEN
        Itinerary itinerary = new Itinerary();
        Destination destination1 = new Destination("Seattle", 1);
        Destination destination2 = new Destination("New York", 2);

        // WHEN
        itinerary.addDestination(destination1);
        itinerary.addDestination(destination2);

        // THEN
        Assertions.assertEquals(2, itinerary.getNumberOfDestinations());
        Assertions.assertEquals("Seattle", itinerary.getDestination(0).getLocation());
        Assertions.assertEquals(1, itinerary.getDestination(0).getDaysAtLocation());
        Assertions.assertEquals("New York", itinerary.getDestination(1).getLocation());
        Assertions.assertEquals(2, itinerary.getDestination(1).getDaysAtLocation());
    }

    @Test
    public void removeDestination_fromMultiDestinationItinerary_matchingDestinationNoLongerPresent() {
        // GIVEN
        Itinerary itinerary = new Itinerary();
        Destination destination1 = new Destination("Seattle", 1);
        Destination destination2 = new Destination("New York", 2);
        itinerary.addDestination(destination1);
        itinerary.addDestination(destination2);

        // WHEN
        itinerary.removeDestination(1);

        // THEN
        Assertions.assertEquals(1, itinerary.getNumberOfDestinations());
        Assertions.assertEquals("Seattle", itinerary.getDestination(0).getLocation());
        Assertions.assertEquals(1, itinerary.getDestination(0).getDaysAtLocation());
    }

    @Test
    public void removeDestination_fromEmptyItinerary_throwsIndexOutOfBoundsException() {
        // GIVEN
        Itinerary itinerary = new Itinerary();

        // WHEN & THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> itinerary.removeDestination(1));
    }

    @Test
    public void getListOfLocations_fromMultiDestinationItinerary_orderOfLocationsMatchesOrderOfDestinations() {
        // GIVEN
        Itinerary itinerary = new Itinerary();
        Destination destination1 = new Destination("Seattle", 1);
        Destination destination2 = new Destination("New York", 2);
        itinerary.addDestination(destination1);
        itinerary.addDestination(destination2);

        // WHEN
        List<String> locations = itinerary.getListOfLocations();

        // THEN
        Assertions.assertEquals(2, locations.size());
        Assertions.assertEquals("Seattle", locations.get(0));
        Assertions.assertEquals("New York", locations.get(1));
    }

    @Test
    public void getListOfLocations_fromEmptyItinerary_returnsEmptyList() {
        // GIVEN
        Itinerary itinerary = new Itinerary();

        // WHEN
        List<String> locations = itinerary.getListOfLocations();

        // THEN
        Assertions.assertEquals(0, locations.size());
    }

    @Test
    public void getTotalNumberOfDays_fromMultiDestinationItinerary_numberOfDaysMatchesSumOfDaysSpentAtEachLocation() {
        // GIVEN
        Itinerary itinerary = new Itinerary();
        Destination destination1 = new Destination("Seattle", 1);
        Destination destination2 = new Destination("New York", 2);
        itinerary.addDestination(destination1);
        itinerary.addDestination(destination2);

        // WHEN
        int totalNumberOfDays = itinerary.getTotalNumberOfDays();

        // THEN
        Assertions.assertEquals(3, totalNumberOfDays);
    }

    @Test
    public void getTotalNumberOfDays_fromEmptyItinerary_numberOfDaysIsZero() {
        // GIVEN
        Itinerary itinerary = new Itinerary();

        // WHEN
        int totalNumberOfDays = itinerary.getTotalNumberOfDays();

        // THEN
        Assertions.assertEquals(0, totalNumberOfDays);
    }
}
