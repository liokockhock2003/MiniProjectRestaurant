import java.util.ArrayList;

public class Table {
    private int tableId;
    private int capacity;
    private ArrayList<TimeSession> timeSessions;

    public Table(int tableId, int capacity) {
        this.tableId = tableId;
        this.capacity = capacity;
        this.timeSessions = new ArrayList<>();
    }

    public void reserveTable(TimeSession session) {
        timeSessions.add(session);
    }

    public void releaseTable(TimeSession session) {
        timeSessions.remove(session);
    }

    public boolean getAvailable(TimeSession session) {
        for (TimeSession ts : timeSessions) {
            if (ts.overlaps(session)) {
                return false;
            }
        }
        return true;
    }

    public int getTableId() {
        return tableId;
    }

    public int getCapacity() {
        return capacity;
    }
}
