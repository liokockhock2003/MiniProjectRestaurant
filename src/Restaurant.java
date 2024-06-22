import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Restaurant {

    // Method to read the menu from a CSV file and added the food list
    public static void readMenu(ArrayList<Food> food) {
        try {
            File tableFile = new File("src//Menu.csv");
            Scanner readTable = new Scanner(tableFile);
            int foodID;
            String foodName;
            double foodPrice;
            while (readTable.hasNextLine()) {
                String line = readTable.nextLine();
                String[] parts = line.split(",");
                foodID = Integer.parseInt(parts[0]);
                foodName = parts[1];
                foodPrice = Double.parseDouble(parts[2]);
                food.add(new Food(foodID, foodName, foodPrice));
            }
            readTable.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    // Method to read the table information from a CSV file and added the tables list
    public static void readTables(ArrayList<Table> tables) {
        try {
            File tableFile = new File("src//Tablelist.csv");
            Scanner readTable = new Scanner(tableFile);
            int tableId;
            int capacity;
            while (readTable.hasNextLine()) {
                tableId = readTable.nextInt();
                capacity = readTable.nextInt();
                tables.add(new Table(tableId, capacity));
            }
            readTable.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    // Method to set the start time for a reservation
    public static LocalDateTime setStartTime(Scanner sc) {
        while (true) {
            System.out.print("Enter a Start date and Time (yyyy-MM-dd HH:mm): ");
            String input = sc.nextLine();
            // Define the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            try {
                // Parse the input string to a LocalDate object
                LocalDateTime resStart = LocalDateTime.parse(input, formatter);
                System.out.println("You entered: " + resStart);
                return resStart;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date and time format.");
                System.out.println("Please enter the date in yyyy-MM-dd HH:mm format.");
            }
        }
    }

    // Method to set the end time for a reservation
    public static LocalDateTime setEndTime(Scanner sc) {
        while (true) {
            System.out.print("Enter a End date and Time (yyyy-MM-dd HH:mm): ");
            String input = sc.nextLine();
            // Define the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            try {
                // Parse the input string to a LocalDate object
                LocalDateTime resEnd = LocalDateTime.parse(input, formatter);
                System.out.println("You entered: " + resEnd);
                return resEnd;
            } catch (DateTimeParseException e) {
                System.out.println("*** Invalid date and time format.");
                System.out.println("*** Please enter the date in yyyy-MM-dd HH:mm format.");
            }
        }
    }

    // Main method: Entry point of the program
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();
        ArrayList<Table> tables = new ArrayList<>();
        ArrayList<Food> foods = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Bill> bills = new ArrayList<>();
        ArrayList<Review> reviews = new ArrayList<>();
        boolean noTable = true;
        int countOrder = -1;
        int countReservation = -1;
        int customerCount = -1;
        int countBill = -1;

        // Read tables and menu from CSV files
        Restaurant.readTables(tables);
        Restaurant.readMenu(foods);

        int choice = 0;
        do {
            noTable = true;
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("| WELCOME TO OUR RESTAURANT! |");
            System.out.println("++++++++++++++++++++++++++++++");

            System.out.println("[1] Create Reservation");
            System.out.println("[2] Payment");
            System.out.println("[3] Review");
            System.out.println("[0] Exit");
            Scanner sc = new Scanner(System.in);

            System.out.print("| Please choose provided option: ");
            choice = sc.nextInt();
            sc.nextLine();

            // Clear console screen
            System.out.println("\u000c");

            switch (choice) {
                case 0:
                    // Exit the program
                    System.out.println("The program stopped...");
                    System.exit(0);

                case 1:
                    // Create a reservation
                    System.out.println("| Please provide your personal information as below: ");
                    System.out.print("First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Last Name : ");
                    String lastName = sc.nextLine();
                    System.out.print("Phone No. : ");
                    String phone = sc.nextLine();
                    System.out.print("Email     : ");
                    String email = sc.nextLine();

                    System.out.println();
                    System.out.println("| Choose your customer type: ");
                    System.out.println("[1] VIP");
                    System.out.println("[2] Regular");
                    System.out.print("Please choose provided option: ");
                    int customerChoice = sc.nextInt();
                    sc.nextLine();
                    if (customerChoice == 1) {
                        customers.add(new VIP(firstName, lastName, phone, email));
                    } else {
                        customers.add(new Regular(firstName, lastName, phone, email));
                    }
                    customerCount++;

                    // Check for table availability and create reservation
                    do {
                        System.out.println();
                        int numOfPeople;
                        do {
                            System.out.print("Enter the Number of People (Max 6): ");
                            numOfPeople = sc.nextInt();
                            sc.nextLine();
                            if (numOfPeople > 6) {
                                System.out.println("** Please enter valid capacity...");
                            }
                        } while (numOfPeople > 6);

                        LocalDateTime resStartTime = Restaurant.setStartTime(sc);
                        LocalDateTime resEndTime = Restaurant.setEndTime(sc);
                        TimeSession session = new TimeSession(resStartTime, resEndTime);
                        

                        Reservation reservation = new Reservation(numOfPeople, customers.get(customerCount), null, session);
                        
                        int i = 0;
                        for (Table table : tables) {
                            if (table.getAvailable(session) && table.getCapacity() >= numOfPeople) {
                                reservation.confirm(table, session);
                                tables.set(i, table);
                                reservations.add(reservation);
                                countReservation++;
                                noTable = false;
                                break;
                            }
                            i++;
                        }
                        

                        if (noTable) {
                            System.out.println("Please pick different table or time...");
                        }
                        
                    } while (noTable);

                    // Create an order
                    System.out.println();
                    System.out.println("+++++++++++++++++++");
                    System.out.println("| Create an order |");
                    System.out.println("+++++++++++++++++++");

                    for (Food food : foods) {
                        food.printFood();
                    }
                    System.out.println("[0] Finish Order");

                    int foodChoice = 1;
                    // Order order = new Order(orderID, customer);
                    ArrayList<Food> foodList = new ArrayList<>();

                    do {
                        System.out.print("Enter your choice: ");
                        foodChoice = sc.nextInt();

                        for (Food food : foods) {
                            if (foodChoice == food.getfoodID()) {
                                foodList.add(food);
                            }
                        }

                    } while (foodChoice != 0);

                    // Add order to the list
                    Order order = new Order(customers.get(customerCount), foodList);
                    orders.add(order);
                    countOrder++;

                    // Display reservation and order
                    System.out.println("---------------------------");
                    reservations.get(countReservation).displayReservation();
                    System.out.println("---------------------------");
                    orders.get(countOrder).displayOrders();

                    break;
                case 2:
                    // Process payment
                    System.out.println("+++++++++++++++++++++++");
                    System.out.println("| Payment Information |");
                    System.out.println("+++++++++++++++++++++++");
                    System.out.print("Enter order ID: ");
                    int orderID = sc.nextInt();
                    Order payingOrder = new Order();
                    for (Order ord : orders) {
                        if (ord.getOrderID() == orderID) {
                            bills.add(new Bill(ord));
                            payingOrder = ord;
                            countBill++;
                        }
                    }

                    Payment payment = new Payment();

                    boolean success = false;
                    do {
                        success = payment.processPayment(bills.get(countBill), sc);
                    } while (!success);
                    
                    // Release table after payment
                    int i=0;
                    for(Reservation reservation: reservations){
                        if(reservation.getCustomer().getCustomerID() == payingOrder.getCustomer().getCustomerID()){
                            reservations.remove(reservation);

                            for(Table table: tables){
                                if(reservation.getTable().getTableId() == table.getTableId() ){
                                    table.releaseTable(reservation.getTimeSession());
                                    tables.set(i, table);
                                    countReservation--;
                                } 
                                i++;      
                            }
                            break;
                        }
                    }

                    break;
                case 3:
                    // Leave a review
                    Review review = new Review();
                    System.out.print("Please enter your name: ");
                    String custName = sc.nextLine();
                    for (Customer customer : customers) {
                        if (customer.getName().equals(custName)) {
                            review.reviewForm(sc, customer);
                            reviews.add(review);
                        }
                    }
                    reviews.get(0).displayReview();
                    break;

                default:
                    // Invalid choice
                    System.out.println("Invalid input! Please enter the provided option.");
                    break;
            }

            System.out.println("\u000c");

        } while (choice > 0);

    }
}
