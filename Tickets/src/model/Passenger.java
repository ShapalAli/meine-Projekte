package model;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private int id;
    private String name;
    private int age;
    private List<Ticket> tickets;

    public Passenger(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.tickets = new ArrayList<>();
    }

    public void buyTicket(Ticket ticket) {
        tickets.add(ticket);
        System.out.println(name + " hat das Ticket gekauft: " + ticket.getType());
    }

    public void listTickets() {
        System.out.println(name + " hat folgende Tickets:");
        for (Ticket ticket : tickets) {
            System.out.println("- " + ticket.getType() + " (Preis: " + ticket.getPrice() + "€)");
        }
    }
}
