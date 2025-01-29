// Task 21: Implement a mouse listener using an adapter class to handle mouse events
// like mouseClicked() and mouseEntered().

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class A21_MouseListenerExample {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Mouse Listener Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel to display messages
        JLabel label = new JLabel("Hover over or click the panel", SwingConstants.CENTER);

        // Create a JPanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        // Add MouseAdapter to the panel
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse entered the panel");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Mouse exited the panel");
            }
        });

        // Add components to the frame
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(label, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
