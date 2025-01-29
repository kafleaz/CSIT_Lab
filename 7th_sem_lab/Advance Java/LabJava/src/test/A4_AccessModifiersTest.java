// Save this file as AccessModifiersTest.java in the "test" package. //
// Demonstrate the use of public, private, protected, and package-private access 
// modifiers in Java. Use different classes within the same and different packages. 


package test;

import demo.A4_AccessModifiersDemo;

public class A4_AccessModifiersTest extends A4_AccessModifiersDemo {
    public static void main(String[] args) {
        A4_AccessModifiersDemo obj = new A4_AccessModifiersDemo();

        // Accessing public members
        System.out.println("Public Attribute: " + obj.publicAttribute);
        obj.publicMethod();

        // Accessing protected members (through inheritance)
        A4_AccessModifiersTest derivedObj = new A4_AccessModifiersTest();
        System.out.println("Protected Attribute (via inheritance): " + derivedObj.protectedAttribute);
        derivedObj.protectedMethod();

        // Attempting to access private members (will cause errors)
        // System.out.println(obj.privateAttribute); // Not accessible
        // obj.privateMethod(); // Not accessible

        // Attempting to access package-private members (will cause errors)
        // System.out.println(obj.packagePrivateAttribute); // Not accessible
        // obj.packagePrivateMethod(); // Not accessible
    }
}
