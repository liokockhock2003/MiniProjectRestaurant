public class VIP extends Customer {
    private double VIPdiscount;

    public VIP(String name, String phone, String email) {
        super(name, phone, email);
        this.VIPdiscount = 0.08;
    }

    public double getDiscount() {
        return VIPdiscount;
    }

}
