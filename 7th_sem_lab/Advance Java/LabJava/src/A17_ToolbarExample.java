// Task 17: Create a toolbar with buttons for common actions like "New," "Open," and "Save."
// Add tooltips for each button.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A17_ToolbarExample {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Toolbar Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JToolBar
        JToolBar toolBar = new JToolBar();

        // Create buttons for the toolbar
        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");

        // Add tooltips to buttons
        newButton.setToolTipText("Create a new file");
        openButton.setToolTipText("Open an existing file");
        saveButton.setToolTipText("Save the current file");

        // Add action listeners for buttons
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New button clicked");
            }
        });

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open button clicked");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save button clicked");
            }
        });

        // Add buttons to the toolbar
        toolBar.add(newButton);
        toolBar.add(openButton);
        toolBar.add(saveButton);

        // Add toolbar to the frame
        frame.add(toolBar, "North");

        // Make the frame visible
        frame.setVisible(true);
    }
}
