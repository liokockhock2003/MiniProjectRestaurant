import java.time.LocalDateTime;

public class Reservation {
    private static int reservationID;
    private int numOfPeople;
    private Customer customer;
    private Table table;
    private TimeSession session;

    public Reservation(int numOfPeople, Customer customer, Table table, TimeSession session) {
        this.numOfPeople = numOfPeople;
        reservationID++;
        this.customer = customer;
        this.table = table;
        this.session = session;
    }

    public void confirm(Table table, TimeSession session) {
        this.table = table;
        table.reserveTable(session);
    }

    public void cancel() {
        if (table != null) {
            table.releaseTable(session);
        }
    }

    public void displayReservation() {
        System.out.println("Reservation ID  : " + reservationID);
        System.out.println("Customer Name   : " + customer.getName());
        System.out.println("Start           : " + session.getStartTime());
        System.out.println("End             : " + session.getEndTime());
        System.out.println("Number Of People: " + numOfPeople);
        System.out.println("Table ID        : " + table.getTableId());
    }
}
