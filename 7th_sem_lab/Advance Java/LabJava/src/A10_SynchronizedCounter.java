// Task 10: Create a program where multiple threads update a shared counter.
// Use synchronization to ensure thread-safe operations.

class SharedCounter {
    private int counter = 0;

    // Synchronized method to increment the counter
    public synchronized void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
    }

    public int getCounter() {
        return counter;
    }
}

class CounterThread extends Thread {
    private final SharedCounter sharedCounter;

    public CounterThread(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedCounter.increment();
            try {
                Thread.sleep(100); // Pause for better thread interleaving
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class A10_SynchronizedCounter {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // Create multiple threads
        Thread t1 = new CounterThread(sharedCounter);
        Thread t2 = new CounterThread(sharedCounter);

        // Start threads
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t1.start();
        t2.start();

        // Wait for threads to complete
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final counter value
        System.out.println("Final counter value: " + sharedCounter.getCounter());
    }
}
