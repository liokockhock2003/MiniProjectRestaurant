import java.util.ArrayList;

public class Waitlist {
    private int waitID;
    private boolean status;
    private ArrayList<Reservation> waitlist;

    public Waitlist() {
        this.waitlist = new ArrayList<>();
    }

    public void addToWaitlist(Reservation reservation) {
        waitlist.add(reservation);
    }

    public void removeFromWaitlist(Reservation reservation) {
        waitlist.remove(reservation);
    }

    public ArrayList<Reservation> getWaitlist() {
        return waitlist;
    }

    // public Reservation promoteFromWaitlist(ArrayList<Table> tables) {
    // for (Reservation reservation : waitlist) {
    // for (Table table : tables) {
    // if (table.getAvailable() && table.getCapacity() >=
    // reservation.getNumberOfPeople()) {
    // reservation.confirm(table);
    // waitlist.remove(reservation);
    // return reservation;
    // }
    // }
    // }
    // return null;
    // }
}
