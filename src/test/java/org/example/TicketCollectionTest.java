package org.example;//tested by Xingcai Zhang

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
    public void testAddValidTickets() {
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* 参数 */); // 填写Flight类所需参数
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
        Ticket invalidTicket = new Ticket(-1, 1000, null, false, null);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(invalidTicket);

        TicketCollection.addTickets(ticketsToAdd);
    }

    @Test
    public void testGetTicketInfo() {
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* 参数 */); // 填写Flight类所需参数
        Ticket ticket1 = new Ticket(1, 1000, flight, false, passenger);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket1);

        TicketCollection.addTickets(ticketsToAdd);

        Ticket retrievedTicket = TicketCollection.getTicketInfo(1);
        assertNotNull(retrievedTicket);
        assertEquals(1, retrievedTicket.getTicket_id());
    }

     @Test
    public void testGetAllTickets() {
        Airplane airplane = new Airplane(1, "Boeing 737", 20, 100, 10);
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(1, "Beijing", "Shanghai", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), airplane); // 填写Flight类所需参数
        Ticket ticket1 = new Ticket(1, 1000, flight, false, passenger);
        Ticket ticket2 = new Ticket(2, 1500, flight, true, passenger);

        ArrayList<Ticket> ticketsToAdd = new ArrayList<>();
        ticketsToAdd.add(ticket1);
        ticketsToAdd.add(ticket2);

        TicketCollection.addTickets(ticketsToAdd);
        TicketCollection.getAllTickets();

        assertEquals(2, TicketCollection.getTickets().size());
    }

}
