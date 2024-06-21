public class Staff extends User {

    private int staffID;

    public Staff(String name, String phone, String email, int staffID) {
        super(name, phone, email);
        this.staffID = staffID;
    }

    public int getStaffID() {
        return staffID;
    }

}
