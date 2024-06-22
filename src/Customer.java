// Abstract class Customer extending User and implementing Discountable interface
abstract class Customer extends User implements Discountable {
    private int custID;

    public Customer(String firstName, String lastName, String phone, String email) {
        super(firstName, lastName, phone, email);
        custID++;
    }

    public int getCustomerID() {
        return custID;
    }

    // Abstract method to be implemented by subclasses to get the discount
    @Override
    public abstract double getDiscount();
}
