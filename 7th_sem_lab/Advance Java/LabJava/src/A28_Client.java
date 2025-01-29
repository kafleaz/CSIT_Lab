// Task 28: Client - Sends a message to the server and receives the reversed message.

import java.io.*;
import java.net.*;

public class A28_Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost"; // Server address
        final int PORT = 12345; // Server port number

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT)) {
            System.out.println("Connected to the server!");

            // Set up input and output streams
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a message to the server
            System.out.print("Enter a message to send to the server: ");
            String message = userInput.readLine();
            output.println(message);

            // Receive the reversed message from the server
            String serverResponse = input.readLine();
            System.out.println("Reversed message from server: " + serverResponse);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
