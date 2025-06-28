package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * CREATE DATABASE mydatabases;
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println("Main thread started.");

        // Thread to connect to MySQL DB
        Thread dbThread = new Thread(() -> {
            try {
                System.out.println("Connecting to MySQL database...");
                // Delay for visibility
                Thread.sleep(1000);

                // JDBC URL, username, password
                String url = "jdbc:mysql://localhost:3306/mydatabase"; // change DB name
                String user = "root";        // change if needed
                String password = "1374";    // change if needed

                // Load MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connect to database
                Connection con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection successful!");

                // Close connection
                con.close();
                System.out.println("Connection closed.");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found.");
            } catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        });

        // Start the thread
        dbThread.start();

        try {
            // Main thread waits for dbThread to complete
            dbThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread completed.");
    }
}
