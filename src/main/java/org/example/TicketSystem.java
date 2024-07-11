package org.example;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class TicketSystem {

    private Passenger passenger;
    private Ticket ticket;
    private Flight flight;
    private Scanner in;

    public TicketSystem() {
        this.passenger = new Passenger();
        this.ticket = new Ticket();
        this.flight = new Flight();
        this.in = new Scanner(System.in);
    }

    public void showTicket() {
        try {
            System.out.println("You have bought a ticket for flight " + ticket.getFlight().getDepartFrom() + " - " + ticket.getFlight().getDepartTo() + "\n\nDetails:");
            System.out.println(this.ticket.toString());
        } catch (NullPointerException e) {
            return;
        }
    }

    public void buyTicket(int ticket_id) throws Exception {
        Ticket validTicket = TicketCollection.getTicketInfo(ticket_id);

        if (validTicket == null) {
            System.out.println("This ticket does not exist.");
            return;
        }

        if (validTicket.ticketStatus()) {
            System.out.println("This ticket is already booked.");
            return;
        }

        flight = validTicket.getFlight();

        try {
            System.out.println("Enter your First Name: ");
            String firstName = "John"; //in.nextLine();
            passenger.setFirstName(firstName);

            System.out.println("Enter your Second name:");
            String secondName = "Doe"; //in.nextLine();
            passenger.setSecondName(secondName);

            System.out.println("Enter your age:");
            Integer age = 22; //in.nextInt();
            //in.nextLine();
            passenger.setAge(age);

            System.out.println("Enter your gender: ");
            String gender = "Man"; //in.nextLine();
            passenger.setGender(gender);

            System.out.println("Enter your e-mail address");
            String email = "john.doe@example.com"; //in.nextLine();
            passenger.setEmail(email);

            System.out.println("Enter your phone number:");
            String phoneNumber = "0412345678"; //in.nextLine();
            passenger.setPhoneNumber(phoneNumber);

            System.out.println("Enter your passport number:");
            String passportNumber = "123456"; //in.nextLine();
            passenger.setPassport(passportNumber);

            System.out.println("Do you want to purchase?\n 1-YES 0-NO");
            int purch = 1; //in.nextInt();
            //in.nextLine();
            if (purch == 0) {
                return;
            } else {
                validTicket.setPassenger(passenger);
                validTicket.setTicketStatus(true);

                Airplane airplane = flight.getAirplane();
                if (validTicket.getClassVip()) {
                    airplane.setBusinessSitsNumber(airplane.getBusinessSitsNumber() - 1);
                } else {
                    airplane.setEconomySitsNumber(airplane.getEconomySitsNumber() - 1);
                }

                System.out.println("Your bill: " + validTicket.getPrice() + "\n");

                System.out.println("Enter your card number:");
                String cardNumber = "1234123412341234"; //in.nextLine();
                passenger.setCardNumber(cardNumber);

                System.out.println("Enter your security code:");
                Integer securityCode = 444444; //in.nextInt();
                //in.nextLine();
                passenger.setSecurityCode(securityCode);
            }
        } catch (PatternSyntaxException patternException) {
            patternException.printStackTrace();
        }
    }

    public void chooseTicket(String city1, String city2) throws Exception {
        Flight flight = FlightCollection.getFlightInfo(city1, city2);

        if (flight != null) {
            TicketCollection.getAllTickets();

            System.out.println("\nEnter ID of ticket you want to choose:");
            int ticket_id = 1; //in.nextInt();
            //in.nextLine();

            buyTicket(ticket_id);
        } else {
            Flight depart_to = FlightCollection.getFlightInfo(city2);
            String connectCity = depart_to.getDepartFrom();

            Flight flightConnectingTwoCities = FlightCollection.getFlightInfo(city1, connectCity);

            if (flightConnectingTwoCities != null) {
                System.out.println("There is a special way to go there. And it is a transfer way, like above.");

                buyTicket(depart_to.getFlightID());
                buyTicket(flightConnectingTwoCities.getFlightID());
            } else {
                System.out.println("There are no possible variants.");
            }
        }
    }

    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        try {
            system.chooseTicket("Beijing", "Shanghai");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
