package model;

public class Ticket implements Payable {
    private int id;
    private TicketType type;
    private double price;

    public Ticket(int id, TicketType type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public TicketType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double calculateDiscount(double discountPercent) {
        return price - (price * discountPercent / 100);
    }

    @Override
    public void pay(double amount) {
        if (amount < price) {
           throw new IllegalArgumentException("Nicht genügend Geld!");


        }
        System.out.println("Zahlung erfolgreich: " + amount + "€");
    }
}
