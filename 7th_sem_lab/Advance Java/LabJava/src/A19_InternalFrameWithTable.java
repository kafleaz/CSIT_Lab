// Task 19: Create a GUI with a JInternalFrame and a JTable to display
// a list of students with their names and grades.

import javax.swing.*;

public class A19_InternalFrameWithTable {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Internal Frame with Table");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JDesktopPane to hold the JInternalFrame
        JDesktopPane desktopPane = new JDesktopPane();

        // Create a JInternalFrame
        JInternalFrame internalFrame = new JInternalFrame("Student Grades", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        // Create a JTable to display student data
        String[] columnNames = {"Name", "Grade"};
        Object[][] data = {
                {"Alice", "A"},
                {"Bob", "B"},
                {"Charlie", "A"},
                {"Diana", "C"}
        };
        JTable table = new JTable(data, columnNames);

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the internal frame
        internalFrame.add(scrollPane);

        // Add the internal frame to the desktop pane
        desktopPane.add(internalFrame);

        // Add the desktop pane to the main frame
        frame.add(desktopPane);

        // Make the frame visible
        frame.setVisible(true);
    }
}
