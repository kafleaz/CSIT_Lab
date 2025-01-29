// Task 25: Write a program to perform a transaction with multiple SQL statements.
// Rollback the transaction in case of an error.

import java.sql.*;

public class A25_TransactionManagement {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/postgres"; // Replace with your database URL
        final String USER = "postgres"; // Replace with your username
        final String PASSWORD = "kafle126"; // Replace with your password

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database successfully!");

            // Disable auto-commit for transaction management
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                // SQL statements to perform
                String sql1 = "INSERT INTO Students (name, grade) VALUES ('John', 'A')";
                String sql2 = "UPDATE Students SET grade = 'B' WHERE name = 'Alice'";
                String sql3 = "DELETE FROM Students WHERE name = 'Charlie'";

                // Execute the SQL statements and print actions
                System.out.println("Executing: " + sql1);
                statement.executeUpdate(sql1);
                System.out.println("Executed: " + sql1);

                System.out.println("Executing: " + sql2);
                statement.executeUpdate(sql2);
                System.out.println("Executed: " + sql2);

                // Uncomment the line below to simulate an error and test rollback
                // int result = 10 / 0; // Simulated error

                System.out.println("Executing: " + sql3);
                statement.executeUpdate(sql3);
                System.out.println("Executed: " + sql3);

                // Commit the transaction
                connection.commit();
                System.out.println("Transaction committed successfully!");
            } catch (Exception e) {
                // Rollback the transaction in case of error
                System.out.println("Transaction failed! Rolling back changes.");
                connection.rollback();
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
}
