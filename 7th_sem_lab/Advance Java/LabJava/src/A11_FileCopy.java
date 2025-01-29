// Task 11: Create a program to read from a text file and write its content to another file, line by line.

import java.io.*;

public class A11_FileCopy {
    public static void main(String[] args) {
        // Specify the source and destination file paths
        String sourceFile = "src/source.txt";
        String destinationFile = "src/destination.txt";

        // Try-with-resources for safe handling of resources
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;

            // Read and write line by line
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add a new line in the destination file
            }

            System.out.println("File content has been successfully copied.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
