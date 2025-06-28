package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


/*
 * -- Create Database (if not already)
CREATE DATABASE school;

-- Use the database
USE school;

-- Create Student table
CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    course VARCHAR(50)
);
 */
public class Task2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // MySQL DB credentials
        String url = "jdbc:mysql://localhost:3306/school";  // Change DB name if needed
        String user = "root"; // Change to your MySQL username
        String password = "1374"; // Change to your MySQL password

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");

            // Input from user
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            // Prepare insert statement
            String query = "INSERT INTO student (id, name, age, course) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);

            // Execute insert
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student data inserted successfully.");
            } else {
                System.out.println("Insert failed.");
            }

            // Close resources
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }

        scanner.close();
    }
}
