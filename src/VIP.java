public class VIP extends Customer {
    private double VIPdiscount;

    public VIP(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        this.VIPdiscount = 0.08;
    }

    @Override
    public double getDiscount() {
        return VIPdiscount;
    }

}
