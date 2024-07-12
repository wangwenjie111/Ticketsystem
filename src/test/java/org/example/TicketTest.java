package org.example; // tested by Xingcai Zhang 34355979
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketTest {

    @Test
    public void testTicketCreation() {
        Passenger passenger = new Passenger("John", "Doe", 25, "Male", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* parameters */); // Fill in the required parameters for the Flight class
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);
        assertEquals(1, ticket.getTicket_id());
        assertEquals(1000 * 1.12, ticket.getPrice(), 0.01); // Check price after service tax
        assertEquals(flight, ticket.getFlight());
        assertEquals(false, ticket.getClassVip());
        assertEquals(false, ticket.ticketStatus());
        assertEquals(passenger, ticket.getPassenger());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTicketID() {
        Ticket ticket = new Ticket();
        ticket.setTicket_id(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPrice() {
        Ticket ticket = new Ticket();
        ticket.setPrice(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFlight() {
        Ticket ticket = new Ticket();
        ticket.setFlight(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassenger() {
        Ticket ticket = new Ticket();
        ticket.setPassenger(null);
    }

    @Test
    public void testValidFlightAndPassenger() {
        Passenger passenger = new Passenger("John", "Doe", 25, "Male", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* parameters */);
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);
        assertNotNull(ticket.getPassenger());
        assertNotNull(ticket.getFlight());
    }

    @Test
    public void testSaleByAge() {
        Passenger child = new Passenger("Child", "Doe", 10, "Male", "child.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Passenger adult = new Passenger("Adult", "Doe", 30, "Male", "adult.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Passenger elderly = new Passenger("Elderly", "Doe", 65, "Male", "elderly.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);

        Flight flight = new Flight(/* parameters */);

        Ticket childTicket = new Ticket(1, 1000, flight, false, child);
        assertEquals(1000 * 0.5 * 1.12, childTicket.getPrice(), 0.01); // 50% discount plus service tax

        Ticket adultTicket = new Ticket(2, 1000, flight, false, adult);
        assertEquals(1000 * 1.12, adultTicket.getPrice(), 0.01); // No discount, only service tax

        Ticket elderlyTicket = new Ticket(3, 1000, flight, false, elderly);
        assertEquals(0, elderlyTicket.getPrice(), 0.01); // 100% discount
    }

    @Test
    public void testServiceTaxApplication() {
        Passenger passenger = new Passenger("John", "Doe", 25, "Male", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* parameters */); // Fill in the required parameters for the Flight class
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);
        ticket.setPrice(1000); // Ensure passenger and flight are initialized
        assertEquals(1000 * 1.12, ticket.getPrice(), 0.01); // Check price after service tax
    }
}
