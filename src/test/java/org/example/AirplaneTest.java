package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirplaneTest {
    private Airplane airplane;

    @BeforeEach
    void setUp() {
        airplane = new Airplane(1, "Boeing 737", 12, 150, 6);
        assertEquals("Boeing 737", airplane.getAirplaneModel());
        assertEquals(12, airplane.getBusinessSitsNumber());
        assertEquals(150, airplane.getEconomySitsNumber());
        assertEquals(6, airplane.getCrewSitsNumber());
    }

    @Test
    void testAirplaneID() {
        airplane.setAirplaneID(2);
        assertEquals(2, airplane.getAirplaneID());
    }

    @Test
    void testAirplaneModel() {
        airplane.setAirplaneModel("Airbus A320");
        assertEquals("Airbus A320", airplane.getAirplaneModel());
    }


    @Test
    void testSetEconomySitsNumber() {
        airplane.setEconomySitsNumber(200);
        assertEquals(200, airplane.getEconomySitsNumber());
    }

    @Test
    void testSetCrewSitsNumber() {
        airplane.setCrewSitsNumber(10);
        assertEquals(10, airplane.getCrewSitsNumber());
    }
    @Test
    void testValidTotalSeats() {
        airplane.setBusinessSitsNumber(50);
        airplane.setEconomySitsNumber(200);
        airplane.setCrewSitsNumber(10);
        int totalSeats = airplane.getBusinessSitsNumber() + airplane.getEconomySitsNumber() + airplane.getCrewSitsNumber();
        assertTrue(totalSeats >= 1 && totalSeats <= 300, "Total seats should be in the range [1, 300]");
    }


    @Test
    void testInvalidTotalSeatsLow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(1, "Boeing 737", 0, 0, 0);
        });
        assertEquals("Total seats number must be in the range [1, 300]", exception.getMessage());
    }

    @Test
    void testInvalidTotalSeatsHigh() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Airplane(1, "Boeing 737", 150, 150, 10);
        });
        assertEquals("Total seats number must be in the range [1, 300]", exception.getMessage());
    }


    @Test
    void testToString() {
        String expected = "Airplane{model=Boeing 737', business sits=12', economy sits=150', crew sits=6'}";
        assertEquals(expected, airplane.toString());
    }
}
