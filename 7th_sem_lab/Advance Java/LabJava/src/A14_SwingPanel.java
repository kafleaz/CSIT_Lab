// Task 14: Create a Swing application with components like JButton, JLabel, and JTextField.
// Add them to a JPanel, which is then added to a JFrame.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A14_SwingPanel {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Swing Panel Example");

        // Create a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10)); // Grid layout for better alignment

        // Create components
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Submit");
        JLabel output = new JLabel();

        // Add action listener for button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("Hello, " + textField.getText() + "!");
            }
        });

        // Add components to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(output);

        // Add panel to the frame
        frame.add(panel);

        // Set frame properties
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
