import java.util.Scanner;

public class Payment {
    private int count = 0;
    private int paymentID;
    private Bill bill;
    private double payAmount;

    public Payment() {
        count++;
        this.paymentID = count;
    }

    public boolean processPayment(Bill bill, Scanner sc) {
        boolean success = false;
        double discountedPrice = bill.getDiscountedPrice();
        double payAmount = 0;
        double balance;
        System.out.println("Total Amount to pay     : " + discountedPrice);

        System.out.print("Enter the amount to pay : ");
        payAmount = sc.nextDouble();

        if (payAmount >= discountedPrice) {
            success = true;
            balance = payAmount - discountedPrice;
            System.out.println("The return balance: RM " + balance);
            System.out.println("Payment Successful! Thank you!");
        } else {
            success = false;
            balance = discountedPrice - payAmount;
            System.out.println("** Payment Failed. Please Pay Sufficient Amount.");
        }

        return success;
    }

}
