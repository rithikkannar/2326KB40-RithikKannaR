package Day5;
import java.util.HashSet;
import java.util.Iterator;

public class Task2 {
	//UniqueEmailLit 
    public static void main(String[] args) {
        // Create a HashSet to store unique email addresses
        HashSet<String> emailSet = new HashSet<>();

        // Add email addresses (some are duplicates)
        emailSet.add("alice@example.com");
        emailSet.add("bob@example.com");
        emailSet.add("charlie@example.com");
        emailSet.add("alice@example.com"); // Duplicate
        emailSet.add("david@example.com");
        emailSet.add("bob@example.com");   // Duplicate

        // Display all unique emails using an iterator
        System.out.println("Unique Email Addresses:");
        Iterator<String> iterator = emailSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
