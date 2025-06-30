
// Main class
public class Task2 {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	String a=sc.next();
        // Create Runnable objects with different messages
        Runnable task1 = new MessagePrinter(a);
        Runnable task2 = new MessagePrinter("Hello from Thread B");
        Runnable task3 = new MessagePrinter("Hello from Thread C");

        // Create Thread objects and pass the Runnable tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        sc.close();
    }
}
