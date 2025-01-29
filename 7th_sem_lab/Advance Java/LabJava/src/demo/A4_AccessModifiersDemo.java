// Save this file as AccessModifiersDemo.java in the "demo" package.//
// Demonstrate the use of public, private, protected, and package-private access 
// modifiers in Java. Use different classes within the same and different packages. 

package demo;

// Class with various access modifiers
public class A4_AccessModifiersDemo {
    // Public attribute
    public String publicAttribute = "Public Attribute";

    // Private attribute
    private String privateAttribute = "Private Attribute";

    // Protected attribute
    protected String protectedAttribute = "Protected Attribute";

    // Package-private (default) attribute
    String packagePrivateAttribute = "Package-Private Attribute";

    // Public method
    public void publicMethod() {
        System.out.println("Public Method: Accessible from anywhere.");
    }

    // Private method
    private void privateMethod() {
        System.out.println("Private Method: Accessible only within this class.");
    }

    // Protected method
    protected void protectedMethod() {
        System.out.println("Protected Method: Accessible within the package or through inheritance.");
    }

    // Package-private (default) method
    void packagePrivateMethod() {
        System.out.println("Package-Private Method: Accessible only within the package.");
    }

    // Method to demonstrate access within the same class
    public void accessAll() {
        System.out.println("Inside the same class:");
        System.out.println(privateAttribute);
        privateMethod();
    }
}
