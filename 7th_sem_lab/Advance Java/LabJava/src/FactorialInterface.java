import java.rmi.Remote;
import java.rmi.RemoteException;

// Define the remote interface
public interface FactorialInterface extends Remote {
    // Method to calculate factorial
    int calculateFactorial(int number) throws RemoteException;
}
