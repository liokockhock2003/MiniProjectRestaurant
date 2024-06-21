public class Staff extends User {

    private int staffID;

    public Staff(String firstName, String lastName, String phone, String email, int staffID) {
        super(firstName, lastName, phone, email);
        this.staffID = staffID;
    }

    public int getStaffID() {
        return staffID;
    }

}
