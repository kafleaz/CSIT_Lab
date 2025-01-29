// Task 13: Create a simple GUI using AWT and implement the same using Swing in one program.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class A13_CombinedGUI {
    public static void main(String[] args) {
        // Display AWT GUI
        Frame awtFrame = new Frame("AWT Example");
        awtFrame.setLayout(new FlowLayout());
        Label awtLabel = new Label("AWT: Enter your name:");
        TextField awtTextField = new TextField(20);
        Button awtButton = new Button("Submit");
        Label awtOutput = new Label();

        awtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                awtOutput.setText("Hello, " + awtTextField.getText() + "!");
            }
        });

        awtFrame.add(awtLabel);
        awtFrame.add(awtTextField);
        awtFrame.add(awtButton);
        awtFrame.add(awtOutput);
        awtFrame.setSize(300, 200);
        awtFrame.setVisible(true);

        awtFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                awtFrame.dispose();
            }
        });

        // Display Swing GUI
        JFrame swingFrame = new JFrame("Swing Example");
        swingFrame.setLayout(new FlowLayout());
        JLabel swingLabel = new JLabel("Swing: Enter your name:");
        JTextField swingTextField = new JTextField(20);
        JButton swingButton = new JButton("Submit");
        JLabel swingOutput = new JLabel();

        swingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swingOutput.setText("Hello, " + swingTextField.getText() + "!");
            }
        });

        swingFrame.add(swingLabel);
        swingFrame.add(swingTextField);
        swingFrame.add(swingButton);
        swingFrame.add(swingOutput);
        swingFrame.setSize(300, 200);
        swingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swingFrame.setVisible(true);
    }
}
