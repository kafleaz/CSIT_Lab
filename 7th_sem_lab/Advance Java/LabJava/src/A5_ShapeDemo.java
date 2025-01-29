// Save this file as ShapeDemo.java

// Interface with methods area() and perimeter()
interface Shape {
    double area();
    double perimeter();
}

// Circle class implementing the Shape interface
class Circle implements Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Calculate the area of the circle
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    // Calculate the perimeter of the circle
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class implementing the Shape interface
class Rectangle implements Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Calculate the area of the rectangle
    @Override
    public double area() {
        return length * width;
    }

    // Calculate the perimeter of the rectangle
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }

    // Inner class to calculate the diagonal of the rectangle
    class DiagonalCalculator {
        public double calculateDiagonal() {
            return Math.sqrt(length * length + width * width);
        }
    }
}

// Main class to test the program
public class A5_ShapeDemo {
    public static void main(String[] args) {
        // Create a Circle object
        Circle circle = new Circle(5);
        System.out.println("Circle:");
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + circle.perimeter());

        // Create a Rectangle object
        Rectangle rectangle = new Rectangle(4, 3);
        System.out.println("\nRectangle:");
        System.out.println("Area: " + rectangle.area());
        System.out.println("Perimeter: " + rectangle.perimeter());

        // Use the inner class to calculate the diagonal
        Rectangle.DiagonalCalculator diagonalCalculator = rectangle.new DiagonalCalculator();
        System.out.println("Diagonal: " + diagonalCalculator.calculateDiagonal());
    }
}
