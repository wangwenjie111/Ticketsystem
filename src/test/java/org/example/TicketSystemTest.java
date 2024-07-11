package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class TicketSystemTest {

    private TicketSystem ticketSystem;
    private Airplane airplane;
    private Flight flight;
    private Passenger passenger;
    private Ticket ticket;
    private ArrayList<Ticket> tickets;

    @BeforeEach
    public void setUp() {

        TicketCollection.tickets.clear();
        FlightCollection.flights.clear();

        ticketSystem = new TicketSystem();
        airplane = new Airplane(1, "Boeing 737", 12, 150, 6);
        flight = new Flight(1, "Shanghai", "Beijing", "CA123", "Air China",
                Timestamp.valueOf("2024-07-14 08:00:00"), Timestamp.valueOf("2024-07-14 10:00:00"), airplane);
        passenger = new Passenger("John", "Doe", 25, "Man", "john.doe@example.com", "0412345678", "P1234567", "1234567890123456", 123456);
        ticket = new Ticket(1, 100, flight, false, passenger);
        tickets = new ArrayList<>();
        tickets.add(ticket);
        TicketCollection.addTickets(tickets);
        Scanner in = new Scanner(System.in);

        // 确保FlightCollection包含测试所需的航班信息
        FlightCollection.addFlight(flight);

        // 模拟用户输入数据
        String simulatedInput = "John\nDoe\n25\nMan\njohn.doe@example.com\n0412345678\nP1234567\n1\n1234567890123456\n123456\n";
        Passenger passenger = new Passenger("John", "Doe", 25, "Man", "john.doe@example.com", "0412345678", "P1234567", "1234567890123456", 123456);
        //ticketSystem = new TicketSystem(passenger,ticket,flight,in);
    }

    @Test
    public void testShowTicket() {
        ticketSystem.showTicket();
    }

    @Test
    public void testBuyTicket() throws Exception {
        ticketSystem.buyTicket(1);
        assertTrue(ticket.ticketStatus());
    }

    @Test
    public void testChooseTicket_ValidCity() throws Exception {
        ticketSystem.chooseTicket("Beijing", "Shanghai");
        assertTrue(ticket.ticketStatus());
    }

    @Test
    public void testChooseTicket_InvalidCity() throws Exception {
        ticketSystem.chooseTicket("New York", "London");
        assertTrue(ticket.ticketStatus());
    }

    @Test
    public void testBuyTicket_AlreadyBooked() throws Exception {
        ticket.setTicketStatus(true);
        ticketSystem.buyTicket(1);
        assertTrue(ticket.ticketStatus());
    }

    @Test
    public void testPassengerInfoValidation() {
        assertThrows(IllegalArgumentException.class, () -> passenger.setFirstName("1John"));
        assertThrows(IllegalArgumentException.class, () -> passenger.setSecondName("Doe!"));
        assertThrows(IllegalArgumentException.class, () -> passenger.setEmail("john.doe@"));
        assertThrows(IllegalArgumentException.class, () -> passenger.setPhoneNumber("123456"));
        assertThrows(IllegalArgumentException.class, () -> passenger.setPassport("P123456789"));
    }

    @Test
    public void testFlightInfoValidation() {
        assertNotNull(FlightCollection.getFlightInfo("Beijing", "Shanghai"));
    }

    @Test
    public void testTicketInfoValidation() {
        assertNotNull(TicketCollection.getTicketInfo(1));
    }

    @Test
    public void testShowBill() throws Exception {
        ticketSystem.buyTicket(1);
        assertEquals(112, ticket.getPrice()); // Including service tax
    }

    @Test
    public void testBuyTicketIntegration() throws Exception {
        // 测试购票流程
        ticketSystem.buyTicket(1);

        // 验证票务状态
        assertTrue(ticket.ticketStatus());
        assertEquals(112, ticket.getPrice()); // 包含服务税

        // 验证乘客信息
        assertEquals("John", ticket.getPassenger().getFirstName());
        assertEquals("Doe", ticket.getPassenger().getSecondName());
        assertEquals("john.doe@example.com", ticket.getPassenger().getEmail());

        // 验证航班信息
        assertEquals("Shanghai", ticket.getFlight().getDepartTo());
        assertEquals("Beijing", ticket.getFlight().getDepartFrom());
    }

    @Test
    public void testChooseTicketIntegration() throws Exception {
        // 测试选择票的流程
        ticketSystem.chooseTicket("Beijing", "Shanghai");

        // 验证票务状态
        assertTrue(ticket.ticketStatus());

        // 验证乘客信息
        assertEquals("John", ticket.getPassenger().getFirstName());
        assertEquals("Doe", ticket.getPassenger().getSecondName());
        assertEquals("john.doe@example.com", ticket.getPassenger().getEmail());

        // 验证航班信息
        assertEquals("Shanghai", ticket.getFlight().getDepartTo());
        assertEquals("Beijing", ticket.getFlight().getDepartFrom());
    }
}
