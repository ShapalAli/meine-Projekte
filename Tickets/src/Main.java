import model.Passenger;
import model.Ticket;
import model.TicketMachine;
import model.TicketType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.




public class Main {


    public static void main(String[] args) {
        // Erstelle Tickets
        Ticket singleTicket = new Ticket(1, TicketType.SINGLE, 2.50);
        Ticket dayTicket = new Ticket(2, TicketType.DAY, 7.00);

        // Erstelle Fahrgäste
        Passenger passenger1 = new Passenger(1, "Max Mustermann", 30);

        // Erstelle Ticketautomat
        TicketMachine machine1 = new TicketMachine();
        machine1.addTicket(singleTicket);
        machine1.addTicket(dayTicket);

        // Ticketkauf
        machine1.sellTicket(passenger1, singleTicket);

        // Liste der Tickets
        passenger1.listTickets();


    }
}
