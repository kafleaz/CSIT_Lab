// Task 8: Write a program that prompts the user to enter two integers and performs division. 
//Handle exceptions for invalid inputs and division by zero.

import java.util.Scanner;

public class A8_ExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user for two integers
            System.out.print("Enter the first integer: ");
            int num1 = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter the second integer: ");
            int num2 = Integer.parseInt(scanner.nextLine());

            // Perform division
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            // Handle invalid (non-numeric) input
            System.out.println("Error: Please enter valid integers.");

        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Division by zero is not allowed.");

        } finally {
            // Close the scanner
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}
