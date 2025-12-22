package bankAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    // Core logic object
    private CheckingAccount account;
    
    // GUI Components
    private JFrame frame;
    private JPanel panel;
    private JTextField amountField;
    private JLabel balanceLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton exitButton;

    public GUI() {
        // Initialize the account with a 1.5% interest rate
        account = new CheckingAccount(0.015);
        account.setFirstName("User");
        account.setLastName("Test");
        
        // Setup the Window (JFrame)
        frame = new JFrame("Simple Bank Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        // Create the Panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // Rows, Cols, Hgap, Vgap

        // Initialize Components
        balanceLabel = new JLabel("Current Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        amountField = new JTextField();
        depositButton = new JButton("Deposit Funds");
        withdrawButton = new JButton("Withdraw Funds");
        exitButton = new JButton("Exit Program");

        // Add ActionListener for Deposit
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.deposit(amount);
                    updateBalanceDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        // Add ActionListener for Withdrawal
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.withdrawal(amount); // This uses your overdraft logic!
                    updateBalanceDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        // Add ActionListener for Exit
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, 
                    "Final Account Summary:\n" + 
                    "Total Balance: $" + String.format("%.2f", account.getBalance()));
                System.exit(0);
            }
        });

        // Add everything to the panel
        panel.add(balanceLabel);
        panel.add(new JLabel("Enter Amount:", SwingConstants.CENTER));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(exitButton);

        // Add panel to frame and show
        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateBalanceDisplay() {
        balanceLabel.setText(String.format("Current Balance: $%.2f", account.getBalance()));
        amountField.setText(""); // Clear the input field
    
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (standard Swing practice)
        SwingUtilities.invokeLater(() -> new GUI());
    }
}