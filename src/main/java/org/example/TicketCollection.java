package org.example;//extened by Xingcai Zhang

import java.util.ArrayList;

public class TicketCollection {
	
	public static ArrayList<Ticket> tickets = new ArrayList<>();

	public static ArrayList<Ticket> getTickets() {

		return tickets;
	}

	public static void addTickets(ArrayList<Ticket> tickets_db) {
		ArrayList<Ticket> validTickets = new ArrayList<>();
		for (Ticket ticket : tickets_db) {
			if (isValidTicket(ticket)) {
				validTickets.add(ticket);
			} else {
				throw new IllegalArgumentException("Invalid ticket: " + ticket);
			}
		}
		tickets.addAll(validTickets);
	}
	
	public static void getAllTickets() {
    	//display all available tickets from the Ticket collection
		for (Ticket ticket : tickets) {
			System.out.println(ticket);
		}
    }
	public static Ticket getTicketInfo(int ticket_id) {
    	//SELECT a ticket where ticket id = ticket_id
		for (Ticket ticket : tickets) {
			if (ticket.getTicket_id() == ticket_id) {
				return ticket;
			}
		}
		return null;

    }

	private static boolean isValidTicket(Ticket ticket) {
		return ticket != null && ticket.getTicket_id() >= 0 && ticket.getPrice() >= 0 && ticket.getFlight() != null && ticket.getPassenger() != null;
	}


}
