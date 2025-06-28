package Day6;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Main thread started.");

        // Thread-1 using anonymous inner class
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread-1 - Count: " + i);
                try {
                    Thread.sleep(500); // sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    System.out.println("Thread-1 interrupted.");
                }
            }
            System.out.println("Thread-1 completed.");
        });

        // Thread-2 using anonymous inner class
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread-2 - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread-2 interrupted.");
                }
            }
            System.out.println("Thread-2 completed.");
        });

        // Start Thread-1
        t1.start();
        try {
            // Wait for Thread-1 to finish
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Thread-1.");
        }

        // Start Thread-
        t2.start();
        try {
            // Wait for Thread-2 to finish
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Thread-2.");
        }

        System.out.println("Main thread completed.");
    }
}

