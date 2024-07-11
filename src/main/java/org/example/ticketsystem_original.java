package org.example;

import java.sql.*;
import java.util.*;
import java.util.regex.PatternSyntaxException;

public class ticketsystem_original {

    private Passenger passenger;
    private Ticket ticket;
    private Flight flight;
    private Scanner in;

    public ticketsystem_original() {
        this.passenger = new Passenger();
        this.ticket = new Ticket();
        this.flight = new Flight();
        this.in = new Scanner(System.in);
    }

    public void showTicket() {
        try {
            System.out.println("You have bought a ticket for flight " + ticket.flight.getDepartFrom() + " - " + ticket.flight.getDepartTo() + "\n\nDetails:");
            System.out.println(this.ticket.toString());
        } catch (NullPointerException e) {
            return;
        }
    }

    public void buyTicket(int ticket_id) throws Exception {
        int flight_id;

        Ticket validTicket = TicketCollection.getTicketInfo(ticket_id);

        if (validTicket == null) {
            System.out.println("This ticket does not exist.");
            return;
        }

        flight_id = validTicket.getFlight().getFlightID();

        try {
            System.out.println("Enter your First Name: ");
            String firstName = in.nextLine();
            passenger.setFirstName(firstName);

            System.out.println("Enter your Second name:");
            String secondName = in.nextLine();
            passenger.setSecondName(secondName);

            System.out.println("Enter your age:");
            Integer age = in.nextInt();
            in.nextLine();
            passenger.setAge(age);

            System.out.println("Enter your gender: ");
            String gender = in.nextLine();
            passenger.setGender(gender);

            System.out.println("Enter your e-mail address");
            String email = in.nextLine();
            passenger.setEmail(email);

            System.out.println("Enter your phone number (+7):");
            String phoneNumber = in.nextLine();
            passenger.setPhoneNumber(phoneNumber);

            System.out.println("Enter your passport number:");
            String passportNumber = in.nextLine();
            passenger.setPassport(passportNumber);

            System.out.println("Do you want to purchase?\n 1-YES 0-NO");
            int purch = in.nextInt();
            in.nextLine();
            if (purch == 0) {
                return;
            } else {
                flight = FlightCollection.getFlightInfo(flight_id);

                int airplane_id = flight.getAirplane().getAirplaneID();
                Airplane airplane = Airplane.getAirPlaneInfo(airplane_id);

                ticket = TicketCollection.getTicketInfo(ticket_id);
                ticket.setPassenger(passenger);
                ticket.setTicket_id(ticket_id);
                ticket.setFlight(flight);
                ticket.setPrice(ticket.getPrice());
                ticket.setClassVip(ticket.getClassVip());
                ticket.setTicketStatus(true);

                if (ticket.getClassVip()) {
                    airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                } else {
                    airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                }

                System.out.println("Your bill: " + ticket.getPrice() + "\n");

                System.out.println("Enter your card number:");
                String cardNumber = in.nextLine();
                passenger.setCardNumber(cardNumber);

                System.out.println("Enter your security code:");
                Integer securityCode = in.nextInt();
                in.nextLine();
                passenger.setSecurityCode(securityCode);
            }
        } catch (PatternSyntaxException patternException) {
            patternException.printStackTrace();
        }
    }

    public void buyTicket(int ticket_id_first, int ticket_id_second) throws Exception {
        int flight_id_first;
        int flight_id_second;

        Ticket validTicketfirst = TicketCollection.getTicketInfo(ticket_id_first);
        Ticket validTicketSecond = TicketCollection.getTicketInfo(ticket_id_second);

        if (validTicketfirst == null || validTicketSecond == null) {
            System.out.println("This ticket does not exist.");
            return;
        }

        flight_id_first = validTicketfirst.getFlight().getFlightID();
        flight_id_second = validTicketSecond.getFlight().getFlightID();

        try {
            System.out.println("Enter your First Name: ");
            String firstName = in.nextLine();
            passenger.setFirstName(firstName);

            System.out.println("Enter your Second name:");
            String secondName = in.nextLine();
            passenger.setSecondName(secondName);

            System.out.println("Enter your age:");
            Integer age = in.nextInt();
            in.nextLine();
            passenger.setAge(age);

            System.out.println("Enter your gender: ");
            String gender = in.nextLine();
            passenger.setGender(gender);

            System.out.println("Enter your e-mail address");
            String email = in.nextLine();
            passenger.setEmail(email);

            System.out.println("Enter your phone number (+7):");
            String phoneNumber = in.nextLine();
            passenger.setPhoneNumber(phoneNumber);

            System.out.println("Enter your passport number:");
            String passportNumber = in.nextLine();
            passenger.setPassport(passportNumber);

            System.out.println("Do you want to purchase?\n 1-YES 0-NO");
            int purch = in.nextInt();
            in.nextLine();
            if (purch == 0) {
                return;
            } else {
                Flight flight_first = FlightCollection.getFlightInfo(flight_id_first);

                int airplane_id_first = flight_first.getAirplane().getAirplaneID();
                Airplane airplane_first = Airplane.getAirPlaneInfo(airplane_id_first);

                Flight flight_second = FlightCollection.getFlightInfo(flight_id_second);

                int airplane_id_second = flight_second.getAirplane().getAirplaneID();
                Airplane airplane_second = Airplane.getAirPlaneInfo(airplane_id_second);

                Ticket ticket_first = TicketCollection.getTicketInfo(ticket_id_first);
                Ticket ticket_second = TicketCollection.getTicketInfo(ticket_id_second);

                ticket_first.setPassenger(passenger);
                ticket_first.setTicket_id(ticket_id_first);
                ticket_first.setFlight(flight_first);
                ticket_first.setPrice(ticket_first.getPrice());
                ticket_first.setClassVip(ticket_first.getClassVip());
                ticket_first.setTicketStatus(true);

                if (ticket_first.getClassVip()) {
                    airplane_first.setBusinessSitsNumber(airplane_first.getBusinessSitsNumber() - 1);
                } else {
                    airplane_first.setEconomySitsNumber(airplane_first.getEconomySitsNumber() - 1);
                }

                ticket_second.setPassenger(passenger);
                ticket_second.setTicket_id(ticket_id_second);
                ticket_second.setFlight(flight_second);
                ticket_second.setPrice(ticket_second.getPrice());
                ticket_second.setClassVip(ticket_second.getClassVip());
                ticket_second.setTicketStatus(true);

                if (ticket_second.getClassVip()) {
                    airplane_second.setBusinessSitsNumber(airplane_second.getBusinessSitsNumber() - 1);
                } else {
                    airplane_second.setEconomySitsNumber(airplane_second.getEconomySitsNumber() - 1);
                }

                ticket.setPrice(ticket_first.getPrice() + ticket_second.getPrice());

                System.out.println("Your bill: " + ticket.getPrice() + "\n");

                System.out.println("Enter your card number:");
                String cardNumber = in.nextLine();
                passenger.setCardNumber(cardNumber);

                System.out.println("Enter your security code:");
                Integer securityCode = in.nextInt();
                in.nextLine();
                passenger.setSecurityCode(securityCode);
            }
        } catch (PatternSyntaxException patternException) {
            patternException.printStackTrace();
        }
    }

    public void chooseTicket(String city1, String city2) throws Exception {
        int counter = 1;
        int idFirst = 0;
        int idSecond = 0;

        Flight flight = FlightCollection.getFlightInfo(city1, city2);

        if (flight != null) {
            TicketCollection.getAllTickets();

            System.out.println("\nEnter ID of ticket you want to choose:");
            int ticket_id = in.nextInt();
            in.nextLine();

            buyTicket(ticket_id);
        } else {
            Flight depart_to = FlightCollection.getFlightInfo(city2);
            String connectCity = depart_to.getDepartFrom();

            Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);

            if (flightConnectingTwoCities != null) {
                System.out.println("There is special way to go there. And it is transfer way, like above. Way №" + counter);

                idFirst = depart_to.getFlightID();
                idSecond = flightConnectingTwoCities.getFlightID();
            }

            counter++;

            buyTicket(idFirst, idSecond);

            if (counter == 1) {
                System.out.println("There is no possible variants.");
            }
        }
    }
}
