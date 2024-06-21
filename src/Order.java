import java.util.ArrayList;

public class Order {
    private static int count = 0;
    private int orderID;
    private Customer customer;
    private ArrayList<Food> foodList;
    private double total_price;

    public double getTotalPrice() {
        return total_price;
    }

    public Order(Customer customer, ArrayList<Food> foodList) {
        count++;
        this.orderID = count;
        this.customer = customer;
        this.foodList = foodList;
        this.total_price = 0;
        calculatePrice();
    }

    public void calculatePrice() {
        for (Food food : foodList) {
            total_price += food.getfoodPrice();
        }
    }

    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void displayOrders() {
        System.out.println("Order ID       : " + orderID);
        System.out.println("Customer       : " + customer.getName());
        System.out.println("Ordered Food: ");
        for (Food food : foodList) {
            System.out.println(food.getfoodID() + ". " + food.getfoodName());
        }
        System.out.println("Total Price    : RM" + total_price);
    }
}
