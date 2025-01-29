import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FactorialClient {
    public static void main(String[] args) {
        try {
            // Locate the registry where the server is bound
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the remote object
            FactorialInterface stub = (FactorialInterface) registry.lookup("FactorialService");

            // Send a number to the server and get the factorial
            int number = 5; // Example input
            int result = stub.calculateFactorial(number);

            System.out.println("Factorial of " + number + " is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
