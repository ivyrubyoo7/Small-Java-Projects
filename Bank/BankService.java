class BankService {

    void deposit(Account acc, double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }
        acc.balance += amount;
        acc.transactions.add(new Transaction("Deposit", amount));
    }

    void withdraw(Account acc, double amount) {
        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }
        if (amount > acc.balance) {
            throw new RuntimeException("Insufficient Balance");
        }
        acc.balance -= amount;
        acc.transactions.add(new Transaction("Withdraw", amount));
    }
}