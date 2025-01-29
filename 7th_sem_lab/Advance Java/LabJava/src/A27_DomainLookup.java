// Task 27: Use the InetAddress class to find the hostname and IP address of a given domain name.

import java.net.*;

public class A27_DomainLookup {
    public static void main(String[] args) {
        try {
            // Domain name to look up
            String domainName = "www.google.com"; // Replace with the desired domain name

            // Get the InetAddress object
            InetAddress inetAddress = InetAddress.getByName(domainName);

            // Display hostname and IP address
            System.out.println("Domain Name: " + domainName);
            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("IP Address: " + inetAddress.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve the domain name. " + e.getMessage());
        }
    }
}
