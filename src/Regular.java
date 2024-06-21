public class Regular extends Customer {
    private double regularDiscount;

    public Regular(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        this.regularDiscount = 0;
    }

    @Override
    public double getDiscount() {
        return regularDiscount;
    }

}
