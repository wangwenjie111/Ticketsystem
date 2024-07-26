package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.util.ArrayList;


class FlightCollectionTest {
    private Flight flight1;
    private Flight flight2;
    private Flight flight3;
    private Airplane airplane;
    @BeforeEach
    void setUp() {
        airplane = new Airplane(1, "Boeing 737", 12, 150, 6);
        flight1 = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), airplane);
        flight2 = new Flight(2, "Shanghai", "Guangzhou", "CZ456", "China Southern",
                Timestamp.valueOf("2024-07-15 08:00:00"), Timestamp.valueOf("2024-07-15 10:00:00"), airplane);
        flight3 = new Flight(3, "Guangzhou", "Beijing", "MU789", "China Eastern",
                Timestamp.valueOf("2024-07-16 08:00:00"), Timestamp.valueOf("2024-07-16 10:00:00"), airplane);
        FlightCollection.flights.clear();
    }

    @Test
    void testAddFlights() {
        ArrayList<Flight> flightsToAdd = new ArrayList<>();
        flightsToAdd.add(flight1);
        flightsToAdd.add(flight2);
        FlightCollection.addFlights(flightsToAdd);
        assertEquals(2, FlightCollection.getFlights().size());
        assertTrue(FlightCollection.getFlights().contains(flight1));
        assertTrue(FlightCollection.getFlights().contains(flight2));
    }
    @Test
    void testAddDuplicateFlight() {
        FlightCollection.addFlight(flight1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FlightCollection.addFlight(flight1);
        });
        assertEquals("Flight with this ID already exists in the system.", exception.getMessage());
    }

    @Test
    void testValidCityNames() {
        ArrayList<Flight> flightsToAdd = new ArrayList<>();
        flightsToAdd.add(flight1);
        flightsToAdd.add(flight2);
        FlightCollection.addFlights(flightsToAdd);
        assertNotNull(FlightCollection.getFlightInfo("Shanghai", "Beijing"));
        assertNull(FlightCollection.getFlightInfo("InvalidCity", "Beijing"));
    }

    @Test
    void testGetFlightInfoByCityPair() {
        ArrayList<Flight> flightsToAdd = new ArrayList<>();
        flightsToAdd.add(flight1);
        flightsToAdd.add(flight2);
        FlightCollection.addFlights(flightsToAdd);
        Flight foundFlight = FlightCollection.getFlightInfo("Shanghai", "Beijing");
        assertNotNull(foundFlight);
        assertEquals(flight1, foundFlight);
    }

    @Test
    void testGetFlightInfoByCity() {
        ArrayList<Flight> flightsToAdd = new ArrayList<>();
        flightsToAdd.add(flight1);
        flightsToAdd.add(flight2);
        FlightCollection.addFlights(flightsToAdd);
        Flight foundFlight = FlightCollection.getFlightInfo("Beijing");
        assertNotNull(foundFlight);
        assertEquals(flight1, foundFlight);
    }

    @Test
    void testGetFlightInfoById() {
        ArrayList<Flight> flightsToAdd = new ArrayList<>();
        flightsToAdd.add(flight1);
        flightsToAdd.add(flight2);
        FlightCollection.addFlights(flightsToAdd);
        Flight foundFlight = FlightCollection.getFlightInfo(1);
        assertNotNull(foundFlight);
        assertEquals(flight1, foundFlight);
    }
}
