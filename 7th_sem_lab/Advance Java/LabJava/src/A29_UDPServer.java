// Task 29: Server - Receives a number from the client and responds with its square.

import java.net.*;

public class A29_UDPServer {
    public static void main(String[] args) {
        final int PORT = 12345; // Server port number
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("UDP Server is running on port " + PORT);

            while (true) {
                // Receive the number from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);
                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedData);

                // Parse the number and calculate the square
                int number = Integer.parseInt(receivedData);
                int square = number * number;

                // Send the result back to the client
                String response = String.valueOf(square);
                sendBuffer = response.getBytes();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
                System.out.println("Sent to client: " + response);
            }
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
