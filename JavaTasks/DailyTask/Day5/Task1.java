package Day5;

	import java.util.ArrayList;
	import java.util.Iterator;

	public class Task1 {
	    public static void main(String[] args) {
	        // Create an ArrayList to hold student details (as Strings or custom objects)
	        ArrayList<String> studentList = new ArrayList<>();

	        // Add student details directly
	        studentList.add("ID: 1, Name: Arun, Age: 20");
	        studentList.add("ID: 2, Name: Boobby, Age: 22");
	        studentList.add("ID: 3, Name: alan, Age: 21");

	        // Display using Iterator
	        System.out.println("Student List:");
	        Iterator<String> iterator = studentList.iterator();

	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }
	    }
	}


