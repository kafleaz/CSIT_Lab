// Task 29: Client - Sends a number to the server and receives its square.

import java.net.*;
import java.util.Scanner;

public class A29_UDPClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost"; // Server address
        final int PORT = 12345; // Server port number
        byte[] sendBuffer;
        byte[] receiveBuffer = new byte[1024];

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) { // Use try-with-resources for Scanner
            System.out.print("Enter a number to send to the server: ");
            String number = scanner.nextLine();

            // Send the number to the server
            sendBuffer = number.getBytes();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, PORT);
            clientSocket.send(sendPacket);
            System.out.println("Number sent to the server.");

            // Receive the square from the server
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Square received from the server: " + response);
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
