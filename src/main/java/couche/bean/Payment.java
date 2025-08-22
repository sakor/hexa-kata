public class Payment {
    private double amount;
    private String type; // "cash", "card"

    public Payment(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() { return amount; }
    public String getType() { return type; }
}
