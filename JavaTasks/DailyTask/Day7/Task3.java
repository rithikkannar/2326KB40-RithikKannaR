package Day7;


/*
 * -- Use the database
USE school;

-- Ensure this table exists and has data
CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    course VARCHAR(50)
);
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Task3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school"; // your DB
        String user = "root";       // your MySQL username
        String password = "1374";   // your MySQL password

        try {
            // Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");

            // Create a statement and execute query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // Print header
            System.out.println("--------------------------------------------------");
            System.out.printf("%-10s %-20s %-10s %-10s%n", "ID", "Name", "Age", "Course");
            System.out.println("--------------------------------------------------");

            // Iterate and display result
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.printf("%-10d %-20s %-10d %-10s%n", id, name, age, course);
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}