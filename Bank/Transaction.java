import java.time.LocalDateTime;

class Transaction {
    String type; // Deposit / Withdraw
    double amount;
    LocalDateTime date;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return type + " - ₹" + amount + " at " + date;
    }
}