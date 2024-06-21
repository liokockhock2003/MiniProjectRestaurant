public class Regular extends Customer {
    private double regularDiscount;

    public Regular(String name, String phone, String email) {
        super(name, phone, email);
        this.regularDiscount = 0;
    }

    public double getDiscount() {
        return regularDiscount;
    }

}
