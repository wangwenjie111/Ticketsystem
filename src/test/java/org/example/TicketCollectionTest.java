package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

public class TicketCollectionTest {

    @Before
    public void setUp() {
        TicketCollection.tickets.clear();
    }

    @Test
    public void testGetTickets() {
        // Test to check if the getTickets method returns the correct list of tickets.
        assertTrue(TicketCollection.getTickets().isEmpty());

        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), new Airplane(1, "Boeing 737", 20, 100, 10));
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket);

        TicketCollection.addTickets(ticketsToAdd);

        assertEquals(1, TicketCollection.getTickets().size());
        assertEquals(ticket, TicketCollection.getTickets().get(0));
    }

    @Test
    public void testAddValidTickets() {
        // Test to check if valid tickets are added to the collection correctly.
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), new Airplane(1, "Boeing 737", 20, 100, 10));
        Ticket ticket1 = new Ticket(1, 1000, flight, false, passenger);
        Ticket ticket2 = new Ticket(2, 1500, flight, true, passenger);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket1);
        ticketsToAdd.add(ticket2);

        TicketCollection.addTickets(ticketsToAdd);
        assertEquals(2, TicketCollection.getTickets().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidTicket() {
        // Test to check if an IllegalArgumentException is thrown when an invalid ticket is added.
        Ticket invalidTicket = new Ticket(-1, 1000, null, false, null);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(invalidTicket);

        TicketCollection.addTickets(ticketsToAdd);
    }

    @Test
    public void testAddEmptyTicketList() {
        // Test to check if adding an empty list of tickets does not change the collection.
        ArrayList<Ticket> emptyList = new ArrayList<>();
        TicketCollection.addTickets(emptyList);
        assertTrue(TicketCollection.getTickets().isEmpty());
    }

    @Test
    public void testGetTicketInfo() {
        // Test to check if the getTicketInfo method returns the correct ticket information.
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), new Airplane(1, "Boeing 737", 20, 100, 10));
        Ticket ticket1 = new Ticket(1, 1000, flight, false, passenger);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket1);

        TicketCollection.addTickets(ticketsToAdd);

        Ticket retrievedTicket = TicketCollection.getTicketInfo(1);
        assertNotNull(retrievedTicket);
        assertEquals(1, retrievedTicket.getTicket_id());
    }

    @Test
    public void testGetNonexistentTicketInfo() {
        // Test to check if the getTicketInfo method returns null for a nonexistent ticket.
        Ticket retrievedTicket = TicketCollection.getTicketInfo(999);
        assertNull(retrievedTicket);
    }

    @Test
    public void testGetAllTickets() {
        // Test to check if the getAllTickets method prints all tickets correctly.
        Airplane airplane = new Airplane(1, "Boeing 737", 20, 100, 10);
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), airplane);
        Ticket ticket1 = new Ticket(1, 1000, flight, false, passenger);
        Ticket ticket2 = new Ticket(2, 1500, flight, true, passenger);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket1);
        ticketsToAdd.add(ticket2);

        TicketCollection.addTickets(ticketsToAdd);

        // Capture output to assert it
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        TicketCollection.getAllTickets();

        String expectedOutput = ticket1.toString() + System.lineSeparator() + ticket2.toString() + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(null); // Reset System.out

        assertEquals(2, TicketCollection.getTickets().size());
    }

    @Test
    public void testIsValidTicket() {
        // Test to check if the isValidTicket method correctly validates tickets.
        Passenger passenger = new Passenger("Jane", "Doe", 28, "女性", "jane.doe@example.com", "0412345678", "B12345678", "1234567890123456", 123);
        Airplane airplane = new Airplane(1, "Boeing 737", 20, 100, 10);
        Flight flight = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), airplane);

        Ticket validTicket = new Ticket(1, 500, flight, false, passenger);

        assertTrue(TicketCollection.isValidTicket(validTicket));
    }
}
