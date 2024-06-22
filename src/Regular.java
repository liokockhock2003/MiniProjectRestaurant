public class Regular extends Customer {
    private double regularDiscount;

    public Regular(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        this.regularDiscount = 0;
    }

    // Override the getDiscount method from the Customer class to return the regular discount
    @Override
    public double getDiscount() {
        return regularDiscount;
    }

}
