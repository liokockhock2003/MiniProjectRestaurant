import java.util.InputMismatchException;
import java.util.Scanner;

public class Review {
    private static int reviewID = 0;
    private int rating;
    private String comment;
    private Customer customer;

    public Review() {
    }

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public void reviewForm(Scanner sc, Customer customer) {
        this.customer = customer;
        // Scanner sc = new Scanner(System.in);
        reviewID++;
        while (true) {
            try {
                do {
                    System.out.print("Please rate your meal [1-10]: ");
                    rating = sc.nextInt();
                    if (rating < 1 || rating > 10) {
                        System.out.println("** Please Enter Digit from 1 to 10");
                    }
                } while (rating < 1 || rating > 10);

                break;

            } catch (InputMismatchException e) {
                System.out.println("** Please Enter number only!");
                sc.nextLine();
            }
        }

        sc.nextLine();
        while (true) {
            System.out.print("Feel free to tell us more!: ");
            try {
                comment = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayReview() {
        System.out.println();
        System.out.println("Customer Name   : " + customer.getName());
        System.out.println("Rating          : " + rating);
        System.out.println("Comment         : " + comment);
    }
}
