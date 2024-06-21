abstract class Customer extends User {
    private int custID;

    public Customer(String name, String phone, String email) {
        super(name, phone, email);
        custID++;
    }

    public int getCustomerID() {
        return custID;
    }

    abstract double getDiscount();
}
