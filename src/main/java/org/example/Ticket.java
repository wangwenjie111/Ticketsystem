package org.example;//extended bu Xingcai Zhang 34355979

public class Ticket {
    private int ticket_id;
    private int price;
    Flight flight;
    private boolean classVip; // indicates if this is business class ticket or not
    private boolean status; // indicates status of ticket: if it is bought by someone or not
    Passenger passenger;

    public Ticket(int ticket_id, int price, Flight flight, boolean classVip, Passenger passenger) {
        if (!IsValidTicketID(ticket_id)) {
            throw new IllegalArgumentException("Ticket ID cannot be negative");
        }
        if (!IsValidPrice(price)) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (!IsValidFlight(flight)) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        if (!IsValidPassenger(passenger)) {
            throw new IllegalArgumentException("Passenger cannot be null");
        }
        this.ticket_id = ticket_id;
        this.price = price;
        this.flight = flight;
        this.classVip = classVip;
        this.status = false;
        this.passenger = passenger;
        saleByAge(passenger.getAge());//extend code
        serviceTax();
    }

    public Ticket() {}

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        if (!IsValidTicketID(ticket_id)) {
            throw new IllegalArgumentException("Ticket ID cannot be negative");
        }
        this.ticket_id = ticket_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (!IsValidPrice(price)) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
        saleByAge(passenger.getAge());
        serviceTax();
    }

    public void saleByAge(int age) {
        int price = getPrice();
        if (age < 15) {
            price -= (int) price * 0.5; // 50% sale for children under 15
            this.price = price;
        } else if (age >= 60) {
            this.price = 0; // 100% sale for elder people
        }
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        if (!IsValidFlight(flight)) {
            throw new IllegalArgumentException("Flight cannot be null");
        }
        this.flight = flight;
    }

    public boolean getClassVip() {
        return classVip;
    }

    public void setClassVip(boolean classVip) {
        this.classVip = classVip;
    }

    public boolean ticketStatus() {
        return status;
    }

    public void setTicketStatus(boolean status) {
        this.status = status;
    }

    public void serviceTax() {
        this.price *= 1.12;
    } // 12% service tax

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        if (!IsValidPassenger(passenger)){
            throw new IllegalArgumentException("Passenger cannot be null");
        }
        this.passenger = passenger;
    }

    private boolean IsValidTicketID(int ticket_id) {
        return (ticket_id >= 0);
    }

    private boolean IsValidPrice(int price) {
        return (price >= 0);
    }

    private boolean IsValidFlight(Flight flight) {
        return (flight != null);
    }

    private boolean IsValidPassenger(Passenger passenger) {
        return (passenger != null);
    }
    @Override
    public String toString() {
        return "Ticket{" + '\n' +
                "Price=" + getPrice() + "KZT, " + '\n' +
                getFlight() + '\n' + "Vip status=" + getClassVip() + '\n' +
                getPassenger() + '\n' + "Ticket was purchased=" + ticketStatus() + "\n}";
    }
}
