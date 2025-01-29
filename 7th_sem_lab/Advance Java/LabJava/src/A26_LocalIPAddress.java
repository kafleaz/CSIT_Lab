// Task 26: Write a program to display the local IP address and port number of the host machine.

import java.net.*;
import java.io.*;

public class A26_LocalIPAddress {
    public static void main(String[] args) {
        try {
            // Get the local host information
            InetAddress localHost = InetAddress.getLocalHost();

            // Display the IP address
            System.out.println("Local IP Address: " + localHost.getHostAddress());

            // Open a server socket to get a port number
            try (ServerSocket serverSocket = new ServerSocket(0)) { // Use port 0 to bind to a free port
                int port = serverSocket.getLocalPort();
                System.out.println("Local Port Number: " + port);
            }

        } catch (UnknownHostException e) {
            System.out.println("Error getting local host information: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error getting port number: " + e.getMessage());
        }
    }
}
