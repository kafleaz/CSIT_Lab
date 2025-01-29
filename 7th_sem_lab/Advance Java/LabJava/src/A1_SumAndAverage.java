// Create a program to accept 10 integers from the user, store them in an array, and 
// calculate their sum and average using a for-each loop. 

import java.util.Scanner;

public class A1_SumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int sum = 0;

        // Accepting 10 integers from the user
        System.out.println("Enter 10 integers:");
        for (int i = 0; i < numbers.length; i++) {
//            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Calculating sum using a for-each loop
        for (int num : numbers) {
            sum += num;
        }

        // Calculating average
        double average = (double) sum / numbers.length;

        // Displaying the results
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
    }
}

