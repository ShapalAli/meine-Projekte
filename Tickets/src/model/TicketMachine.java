package model;

import java.util.ArrayList;
import java.util.List;

public class TicketMachine {
    private List<Ticket> availableTickets;

    public List<Ticket> getAvailableTickets() {
        return availableTickets;
    }

    public TicketMachine() {
        this.availableTickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        availableTickets.add(ticket);
        System.out.println("Ticket hinzugefügt: " + ticket.getType());
    }

    public void sellTicket(Passenger passenger, Ticket ticket) {
        if (availableTickets.contains(ticket)) {
            availableTickets.remove(ticket);
            passenger.buyTicket(ticket);
        } else {
            System.out.println("Fehler: Ticket nicht verfügbar.");
        }
    }
}
