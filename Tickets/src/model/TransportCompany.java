package model;

import java.util.ArrayList;
import java.util.List;

public class TransportCompany {
    private String name;
    private List<TicketMachine> machines;

    public TransportCompany(String name) {
        this.name = name;
        this.machines = new ArrayList<>();
    }

    public void addMachine(TicketMachine machine) {
        machines.add(machine);
        System.out.println("Automat hinzugefügt.");
    }

    public void displayAllTickets() {
        System.out.println("Verfügbare Tickets in allen Automaten:");
        for (TicketMachine machine : machines) {
            for (Ticket ticket : machine.getAvailableTickets()) {
                System.out.println("- " + ticket.getType() + " (Preis: " + ticket.getPrice() + "€)");
            }
        }
    }
}
