public class Food {
    private int foodID;
    private String foodName;
    private double foodPrice;

    public Food(int foodID, String foodName, double foodPrice) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getfoodID() {
        return foodID;
    }

    public String getfoodName() {
        return foodName;
    }

    public double getfoodPrice() {
        return foodPrice;
    }

    public void printFood() {
        System.out.println("[" + foodID + "] " + foodName + " RM " + foodPrice);
    }
}
