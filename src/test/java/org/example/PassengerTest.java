package org.example;//tested by Xingcai Zhang 34355979

import org.junit.Test;
import static org.junit.Assert.*;


public class PassengerTest {

    @Test
    public void testPassengerCreation() {
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123456);
        assertEquals("John", passenger.getFirstName());
        assertEquals("Doe", passenger.getSecondName());
        assertEquals(25, passenger.getAge());
        assertEquals("男性", passenger.getGender());
        assertEquals("john.doe@example.com", passenger.getEmail());
        assertEquals("0412345678", passenger.getPhoneNumber());
        assertEquals("A12345678", passenger.getPassport());
        assertEquals("1234567890123456", passenger.getCardNumber());
        assertEquals(123456, passenger.getSecurityCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEmail() {
        Passenger passenger = new Passenger();
        passenger.setEmail("invalidEmail");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhoneNumber() {
        Passenger passenger = new Passenger();
        passenger.setPhoneNumber("123456789");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPassport() {
        Passenger passenger = new Passenger();
        passenger.setPassport("A1234567890");
    }

    @Test
    public void testValidEmail() {
        Passenger passenger = new Passenger();
        passenger.setEmail("valid.email@example.com");
        assertEquals("valid.email@example.com", passenger.getEmail());
    }

    @Test
    public void testValidPhoneNumber() {
        Passenger passenger = new Passenger();
        passenger.setPhoneNumber("0412345678");
        assertEquals("0412345678", passenger.getPhoneNumber());
    }

    @Test
    public void testValidPassport() {
        Passenger passenger = new Passenger();
        passenger.setPassport("A1234567");
        assertEquals("A1234567", passenger.getPassport());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCardNumber() {
        Passenger passenger = new Passenger();
        passenger.setCardNumber("1234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSecurityCode() {
        Passenger passenger = new Passenger();
        passenger.setSecurityCode(12);
    }

    @Test
    public void testValidCardNumber() {
        Passenger passenger = new Passenger();
        passenger.setCardNumber("1234567890123456");
        assertEquals("1234567890123456", passenger.getCardNumber());
    }

    @Test
    public void testValidSecurityCode() {
        Passenger passenger = new Passenger();
        passenger.setSecurityCode(123456);
        assertEquals(123456, passenger.getSecurityCode());
    }
}
