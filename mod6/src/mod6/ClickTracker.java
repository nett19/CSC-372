package mod6;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClickTracker extends JFrame {
    private ArrayList<User> userList = new ArrayList<>();
    private JTextArea statusArea = new JTextArea(12, 35);

    public ClickTracker() {
        // Using your exact 10 Student objects
        userList.add(new User(10, "Zane", "Joined 01/08/2020"));
        userList.add(new User(9, "Alice", "Joined 10/09/2020"));
        userList.add(new User(8, "Charlie", "Joined 08/27/2010"));
        userList.add(new User(7, "Bob", "Joined 12/20/2025"));
        userList.add(new User(6, "Eve", "Joined 11/03/2021"));
        userList.add(new User(5, "David", "Joined 04/19/2018"));
        userList.add(new User(4, "Yara", "Joined 10/09/2009"));
        userList.add(new User(3, "Frank", "Joined 09/10/2021"));
        userList.add(new User(2, "Grace", "Joined 02/02/2001"));
        userList.add(new User(1, "Heidi", "Joined 09/04/2007"));

        setTitle("User Box Clicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for the 10 buttons (2 rows, 5 columns)
        JPanel buttonPanel = new JPanel(new GridLayout(2, 5, 5, 5));

        for (User u : userList) {
            JButton userButton = new JButton(u.name);
            userButton.addActionListener(e -> {
                u.addClick();
                updateLog();
            });
            buttonPanel.add(userButton);
        }

        statusArea.setEditable(false);
        statusArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(statusArea), BorderLayout.CENTER);

        updateLog();
        pack();
        setLocationRelativeTo(null);
    }

    private void updateLog() {
        StringBuilder sb = new StringBuilder("--- Click Counts ---\n");
        for (User u : userList) {
            sb.append(u.toString()).append("\n");
        }
        statusArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        // Launch the application
        SwingUtilities.invokeLater(() -> new ClickTracker().setVisible(true));
    }
}