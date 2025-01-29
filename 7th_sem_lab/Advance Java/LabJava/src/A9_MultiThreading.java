// Task 9: Write a multithreaded program to print numbers from 1 to 10 
// using two threads, where one thread prints odd numbers and the other prints even numbers.

class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(500); // Pause for better interleaving
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(500); // Pause for better interleaving
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class A9_MultiThreading {
    public static void main(String[] args) {
        // Create thread instances
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        // Start threads
        oddThread.start();
        evenThread.start();
    }
}
