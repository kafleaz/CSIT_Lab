// Task 28: Server - Receives a message from the client and responds with the reversed message.

import java.io.*;
import java.net.*;

public class A28_Server {
    public static void main(String[] args) {
        final int PORT = 12345; // Server port number

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Set up input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive the message from the client
            String clientMessage = input.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Reverse the message and send it back
            String reversedMessage = new StringBuilder(clientMessage).reverse().toString();
            output.println(reversedMessage);
            System.out.println("Reversed message sent to client: " + reversedMessage);

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
