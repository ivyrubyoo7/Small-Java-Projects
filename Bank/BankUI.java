import javax.swing.*;

public class BankUI {

    Account account = new Account("Ricky", 1000);
    BankService service = new BankService();

    public BankUI() {

        JFrame frame = new JFrame("Banking System");

        JTextField amountField = new JTextField();
        amountField.setBounds(100, 50, 150, 30);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(100, 100, 120, 30);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(100, 150, 120, 30);

        JButton historyBtn = new JButton("History");
        historyBtn.setBounds(100, 200, 120, 30);

        JLabel result = new JLabel("Balance: ₹1000");
        result.setBounds(100, 250, 250, 30);

        // Deposit
        depositBtn.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                service.deposit(account, amt);
                result.setText("Balance: ₹" + account.balance);
            } catch (Exception ex) {
                result.setText("Error: " + ex.getMessage());
            }
        });

        // Withdraw
        withdrawBtn.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                service.withdraw(account, amt);
                result.setText("Balance: ₹" + account.balance);
            } catch (Exception ex) {
                result.setText("Error: " + ex.getMessage());
            }
        });

        // Transaction History
        historyBtn.addActionListener(e -> {
            if (account.transactions.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No transactions yet");
                return;
            }

            StringBuilder history = new StringBuilder();
            for (Transaction t : account.transactions) {
                history.append(t.toString()).append("\n");
            }

            JOptionPane.showMessageDialog(frame, history.toString());
        });

        frame.add(amountField);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(historyBtn);
        frame.add(result);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}