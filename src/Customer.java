abstract class Customer extends User implements Discountable {
    private int custID;

    public Customer(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        custID++;
    }

    public int getCustomerID() {
        return custID;
    }

    @Override
    public abstract double getDiscount();
}
