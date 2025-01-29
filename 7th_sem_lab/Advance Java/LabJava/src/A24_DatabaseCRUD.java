import java.sql.*;
import java.util.Scanner;

/**
 * Program to connect to a PostgreSQL database and perform CRUD operations
 * on a "Students" table with columns id, name, and grade.
 */
public class A24_DatabaseCRUD {
    public static void main(String[] args) {

        final String URL = "jdbc:postgresql://localhost:5432/postgres"; // Replace with your database URL
        final String USER = "postgres"; // Replace with your username
        final String PASSWORD = "kafle126"; // Replace with your password

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) { // Resource management
            System.out.println("Connected to the database successfully!");

            // Display database metadata
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());

            while (true) {
                System.out.println("\nCRUD Operations:");
                System.out.println("1. Insert Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Query by Grade");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    // Insert Operation
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    String insertSQL = "INSERT INTO students (name, grade) VALUES (?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, grade);
                        int rows = preparedStatement.executeUpdate();
                        System.out.println(rows + " row(s) inserted.");
                    }

                } else if (choice == 2) {
                    // Read Operation
                    String selectSQL = "SELECT * FROM students";
                    try (Statement statement = connection.createStatement();
                         ResultSet resultSet = statement.executeQuery(selectSQL)) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String name = resultSet.getString("name");
                            String grade = resultSet.getString("grade");
                            System.out.println("ID: " + id + ", Name: " + name + ", Grade: " + grade);
                        }
                    }

                } else if (choice == 3) {
                    // Update Operation
                    System.out.print("Enter student ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new grade: ");
                    String grade = scanner.nextLine();

                    String updateSQL = "UPDATE students SET grade = ? WHERE id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                        preparedStatement.setString(1, grade);
                        preparedStatement.setInt(2, id);
                        int rows = preparedStatement.executeUpdate();
                        System.out.println(rows + " row(s) updated.");
                    }

                } else if (choice == 4) {
                    // Delete Operation
                    System.out.print("Enter student ID to delete: ");
                    int id = scanner.nextInt();

                    String deleteSQL = "DELETE FROM students WHERE id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
                        preparedStatement.setInt(1, id);
                        int rows = preparedStatement.executeUpdate();
                        System.out.println(rows + " row(s) deleted.");
                    }

                } else if (choice == 5) {
                    // Query by Grade
                    System.out.print("Enter grade to search: ");
                    String grade = scanner.nextLine();

                    String querySQL = "SELECT * FROM Students WHERE grade = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {
                        preparedStatement.setString(1, grade);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        while (resultSet.next()) {
                            int id = resultSet.getInt("id");
                            String name = resultSet.getString("name");
                            System.out.println("ID: " + id + ", Name: " + name + ", Grade: " + grade);
                        }
                    }

                } else if (choice == 6) {
                    // Exit
                    System.out.println("Exiting program.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
