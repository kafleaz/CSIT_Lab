//Task 7: Design a base class Employee with attributes name and salary, and a derived 
//class Manager with an additional attribute department. Override a method displayDetails() in both classes.

class Employee {
    // Attributes
    protected String name;
    protected double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    // Additional attribute
    private String department;

    // Constructor
    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    // Overriding the displayDetails() method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

public class A7_EmployeeTest {
    public static void main(String[] args) {
        // Creating an Employee object
        Employee emp = new Employee("John Doe", 50000);

        // Creating a Manager object
        Manager mgr = new Manager("Jane Smith", 80000, "IT");

        // Display details of Employee
        System.out.println("Employee Details:");
        emp.displayDetails();

        // Display details of Manager
        System.out.println("\nManager Details:");
        mgr.displayDetails();
    }
}
