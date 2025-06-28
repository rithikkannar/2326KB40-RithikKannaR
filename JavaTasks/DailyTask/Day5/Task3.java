package Day5;

import java.util.HashMap;
import java.util.Map;
;

public class Task3 {
    public static void main(String[] args) {
        // Create a HashMap to store student name and marks
        HashMap<String, Integer> studentMarks = new HashMap<>();

        // Add Indian student names → marks
        studentMarks.put("Ravi", 82);
        studentMarks.put("Priya", 90);
        studentMarks.put("Amit", 76);
        studentMarks.put("Divya", 88);
        studentMarks.put("Kiran", 95);

        // Display all student marks
        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // Calculate total and average
        int total = 0;
        for (int marks : studentMarks.values()) {
            total += marks;
        }
        double average = (double) total / studentMarks.size();

        // Display average
        System.out.println("\nAverage Marks: " + average);
    }
}
