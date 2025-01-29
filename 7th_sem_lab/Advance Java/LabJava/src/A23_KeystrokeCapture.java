// Task 23: Write a program to capture and display keystrokes in a JTextArea.

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class A23_KeystrokeCapture {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Keystroke Capture");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTextArea for capturing and displaying keystrokes
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make it read-only for direct keystroke display
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add KeyListener to capture keystrokes
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                textArea.append("Key Typed: " + e.getKeyChar() + "\n");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                textArea.append("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()) + "\n");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                textArea.append("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()) + "\n");
            }
        });

        // Add the text area to the frame
        frame.add(scrollPane);

        // Make the frame visible
        frame.setFocusable(true); // Ensure the frame captures keystrokes
        frame.setVisible(true);
    }
}
