import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Implementation of the remote interface
public class FactorialServer implements FactorialInterface {
    public FactorialServer() {
        super();
    }

    @Override
    public int calculateFactorial(int number) throws RemoteException {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        try {
            // Create the server object
            FactorialServer server = new FactorialServer();
            FactorialInterface stub = (FactorialInterface) UnicastRemoteObject.exportObject(server, 0);

            // Bind the remote object to the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("FactorialService", stub);

            System.out.println("Factorial Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
