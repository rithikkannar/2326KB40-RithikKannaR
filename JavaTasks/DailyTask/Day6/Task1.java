package Day6;

// Main class with main method
public class Task1 {

    // Inner class extending Thread
    static class NumberPrinter extends Thread {
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Number: " + i);
                try {
                    Thread.sleep(1000);//milli seconds
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        NumberPrinter thread = new NumberPrinter();
        thread.start();
    }
}
