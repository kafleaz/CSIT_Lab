class Student {
    // Attributes
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Method to calculate grade
    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 80) {
            return "B";
        } else if (marks >= 70) {
            return "C";
        } else if (marks >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

public class A2_StudentDetails {
    public static void main(String[] args) {
        // Creating student objects
        Student student1 = new Student(1, "Alice", 95);
        Student student2 = new Student(2, "Bob", 78);
        Student student3 = new Student(3, "Charlie", 62);

        // Displaying details for each student
        System.out.println("Student Details:");
        student1.displayDetails();
        System.out.println();

        student2.displayDetails();
        System.out.println();

        student3.displayDetails();
    }
}
