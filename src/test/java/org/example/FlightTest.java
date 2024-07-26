package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class FlightTest {
    private Flight flight;
    private Airplane airplane;

    @BeforeEach
    void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Timestamp dateFrom = new Timestamp(sdf.parse("15/07/24 10:00:00").getTime());
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Timestamp dateTo = new Timestamp(sdf1.parse("15/07/24 14:00:00").getTime());

        airplane = new Airplane(1, "Boeing 737", 20, 100, 10);
        flight = new Flight(1, "Beijing", "Shanghai", "NYLA001", "Delta", dateFrom, dateTo, airplane);
        assertEquals(1, flight.getFlightID());
        assertEquals("Beijing", flight.getDepartTo());
        assertEquals("Shanghai", flight.getDepartFrom());
        assertEquals("NYLA001", flight.getCode());
        assertEquals("Delta", flight.getCompany());
        assertEquals(dateFrom, flight.getDateFrom());
        assertEquals(dateTo, flight.getDateTo());
        assertEquals(airplane, flight.getAirplane());

    }




    @Test
    void testSetFlightID() {
        flight.setFlightID(2);
        assertEquals(2, flight.getFlightID());
    }



    @Test
    void testSetDepartTo() {
        flight.setDepartTo("Guangzhou");
        assertEquals("Guangzhou", flight.getDepartTo());
    }


    @Test
    void testSetDepartFrom() {
        flight.setDepartFrom("Nanjing");
        assertEquals("Nanjing", flight.getDepartFrom());
    }


    @Test
    void testSetCode() {
        flight.setCode("MU456");
        assertEquals("MU456", flight.getCode());
    }


    @Test
    void testSetCompany() {
        flight.setCompany("China Eastern");
        assertEquals("China Eastern", flight.getCompany());
    }



    @Test
    void testSetDateFrom() throws ParseException {
        Flight flight = new Flight();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Timestamp timestamp = new Timestamp(sdf.parse("15/07/24 10:00:00").getTime());
        flight.setDateFrom(timestamp);
        assertEquals("2024-07-15 10:00:00.0", flight.getDateFrom().toString());
    }

    @Test
    void testSetDateTo() throws ParseException {
        Flight flight = new Flight();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Timestamp timestamp = new Timestamp(sdf.parse("15/07/24 14:00:00").getTime());
        flight.setDateTo(timestamp);
        assertEquals("2024-07-15 14:00:00.0", flight.getDateTo().toString());
    }

    @Test
    void testSetAirplane() {
        Airplane newAirplane = new Airplane(2, "Airbus A320", 20, 180, 8);
        flight.setAirplane(newAirplane);
        assertEquals(newAirplane, flight.getAirplane());
    }

    @Test
    void testGetAirplane() {
        assertEquals(airplane, flight.getAirplane());
    }

    @Test
    void testToString() {
        String expected = "Flight{Airplane{model=Boeing 737', business sits=20', economy sits=100', crew sits=10'}, date to=2024-07-15 14:00:00.0, ', date from='2024-07-15 10:00:00.0', depart from='Shanghai', depart to='Beijing', code=NYLA001', company=Delta', code=NYLA001'}";
        assertEquals(expected, flight.toString());
    }

}
