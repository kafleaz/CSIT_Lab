// Task 20: Create a GUI with a button. When the button is clicked, display
// "Button Clicked!" in a JLabel.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class A20_ButtonClick {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Button Click Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel to display messages
        JLabel label = new JLabel("", SwingConstants.CENTER);

        // Create a JButton
        JButton button = new JButton("Click Me");

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        // Add components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(button, BorderLayout.CENTER);
        frame.add(label, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
