package frames;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuInterface extends JFrame {
    private JTextArea textBox;
    private Color persistentGreenHue;

    public MenuInterface() {
        // Initialize the Frame
        setTitle("Java Menu Interface");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the text box (JTextArea)
        textBox = new JTextArea();
        add(new JScrollPane(textBox), BorderLayout.CENTER);

     // NEW Option 3: Select Custom Background Color
        JMenuItem item3 = new JMenuItem("Select Background Color...");
        item3.addActionListener(e -> {
            // Opens the standard Java Color Chooser dialog
            Color selectedColor = JColorChooser.showDialog(this, "Pick a Background Color", textBox.getBackground());
            
            if (selectedColor != null) {
                textBox.setBackground(selectedColor);
                // Set opaque to true to ensure the color shows up
                textBox.setOpaque(true);
            }
        });
        // Create the Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Controls");

        // Option 1: Print Date and Time
        JMenuItem item1 = new JMenuItem("Print Date/Time");
        item1.addActionListener(e -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            textBox.append(dtf.format(LocalDateTime.now()) + "\n");
        });

        // Option 2: Write to log.txt
        JMenuItem item2 = new JMenuItem("Write to Log");
        item2.addActionListener(e -> {
            try (FileWriter writer = new FileWriter("log.txt")) {
                writer.write(textBox.getText());
                JOptionPane.showMessageDialog(this, "Content saved to log.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
            }
        });

       

        // Option 4: Exit
        JMenuItem item4 = new JMenuItem("Exit");
        item4.addActionListener(e -> System.exit(0));

        // Add items to menu
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuInterface().setVisible(true);
        });
    }
}