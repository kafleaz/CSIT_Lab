// A6_MathConstants.java

// Task 6: Create a class MathConstants with a final variable for PI and a static method to calculate the area of a circle.

public class A6_MathConstants {
    // Final constant for PI
    public static final double PI = 3.14159;

    // Static method to calculate the area of a circle
    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        // Example usage
        double radius = 5.0; // You can change the value to test with different radii
        double area = calculateCircleArea(radius);
        System.out.println("The area of the circle with radius " + radius + " is: " + area);
    }
}
