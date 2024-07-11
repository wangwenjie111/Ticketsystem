package org.example;//tested by Xingcai Zhang
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketTest {

    @Test
    public void testTicketCreation() {
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* 参数 */); // 填写Flight类所需参数
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);
        assertEquals(1, ticket.getTicket_id());
        assertEquals(1000 * 1.12, ticket.getPrice(), 0.01); // 检查服务税后的价格
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
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* 参数 */);
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);
        assertNotNull(ticket.getPassenger());
        assertNotNull(ticket.getFlight());
    }

    @Test
    public void testSaleByAge() {
        Passenger child = new Passenger("Child", "Doe", 10, "男性", "child.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Passenger adult = new Passenger("Adult", "Doe", 30, "男性", "adult.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Passenger elderly = new Passenger("Elderly", "Doe", 65, "男性", "elderly.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);

        Flight flight = new Flight(/* 参数 */);

        Ticket childTicket = new Ticket(1, 1000, flight, false, child);
        assertEquals(1000 * 0.5 * 1.12, childTicket.getPrice(), 0.01); // 50% 折扣后加服务税

        Ticket adultTicket = new Ticket(2, 1000, flight, false, adult);
        assertEquals(1000 * 1.12, adultTicket.getPrice(), 0.01); // 无折扣，仅服务税

        Ticket elderlyTicket = new Ticket(3, 1000, flight, false, elderly);
        assertEquals(0, elderlyTicket.getPrice(), 0.01); // 100% 折扣
    }

    @Test
    public void testServiceTaxApplication() {
        Passenger passenger = new Passenger("John", "Doe", 25, "男性", "john.doe@example.com", "0412345678", "A12345678", "1234567890123456", 123);
        Flight flight = new Flight(/* 参数 */); // 填写Flight类所需参数
        Ticket ticket = new Ticket(1, 1000, flight, false, passenger);
        ticket.setPrice(1000); // 确保乘客和航班已初始化
        assertEquals(1000 * 1.12, ticket.getPrice(), 0.01); // 检查服务税后的价格
    }
}
