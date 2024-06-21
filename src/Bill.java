public class Bill {
    private static int count = 0;
    private int billID;
    private Order order;
    private double discountedPrice;

    public Bill(Order order) {
        count++;
        this.billID = count;
        this.order = order;
        discountedPrice = order.getTotalPrice() - (order.getTotalPrice() * order.getCustomer().getDiscount());
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void getBillDetails() {
        System.out.println("Bill ID: "+billID);
        order.displayOrders();
        System.out.println("Discounted Price: "+ discountedPrice);
    }
}
