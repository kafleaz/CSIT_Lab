// Task 15: Design a calculator-like GUI using BorderLayout with buttons 
// at different positions (NORTH, SOUTH, EAST, WEST, and CENTER).

import javax.swing.*;
import java.awt.*;

public class A15_BorderLayoutCalculator {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("BorderLayout Calculator");

        // Set BorderLayout for the frame
        frame.setLayout(new BorderLayout(10, 10));

        // Create buttons for different positions
        JButton northButton = new JButton("NORTH");
        JButton southButton = new JButton("SOUTH");
        JButton eastButton = new JButton("EAST");
        JButton westButton = new JButton("WEST");
        JButton centerButton = new JButton("CENTER");

        // Add buttons to the frame at the respective positions
        frame.add(northButton, BorderLayout.NORTH);
        frame.add(southButton, BorderLayout.SOUTH);
        frame.add(eastButton, BorderLayout.EAST);
        frame.add(westButton, BorderLayout.WEST);
        frame.add(centerButton, BorderLayout.CENTER);

        // Set frame properties
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
