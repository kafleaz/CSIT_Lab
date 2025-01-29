// Task 12: Create a program to serialize and deserialize an object of a Book class
// with attributes title, author, and price.

import java.io.*;

// Book class implementing Serializable interface
class Book implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class A12_BookSerialization {
    public static void main(String[] args) {
        String fileName = "book.ser";

        // Create a Book object
        Book book = new Book("Java Programming", "John Doe", 599.99);

        // Serialize the Book object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(book);
            System.out.println("Book object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialize the Book object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Book deserializedBook = (Book) ois.readObject();
            System.out.println("\nBook object deserialized successfully.");
            deserializedBook.displayDetails();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
