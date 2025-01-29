// Write a program to demonstrate method overloading by implementing a 
// Calculator class with overloaded methods for add (supporting 2, 3, and 4 
// integers). 

class Calculator {

    // Method to add 2 integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add 3 integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add 4 integers
    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}

public class A3_MethodOverloadingDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Testing overloaded add methods
        int sum2 = calculator.add(10, 20);
        int sum3 = calculator.add(5, 15, 25);
        int sum4 = calculator.add(1, 2, 3, 4);

        // Display results
        System.out.println("Sum of 2 numbers: " + sum2);
        System.out.println("Sum of 3 numbers: " + sum3);
        System.out.println("Sum of 4 numbers: " + sum4);
    }
}

