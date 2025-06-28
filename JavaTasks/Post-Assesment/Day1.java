import java.util.Scanner;

public class StudentMarks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        
        int highest = 0;
        
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark for student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }
 
        System.out.println("\nStudent Marks and Grades:");
        for (int i = 0; i < n; i++) {
          String grade; 
            int gradeCategory = marks[i] / 10;      
            switch (gradeCategory) {
                case 10:
                	grade = "Centum";
                case 9:
                    grade = "A";
                    break;
                case 8:
                    grade = "B";
                    break;
                case 7:
                    grade = "C";
                    break;
                case 6:
                    grade = "D";
                    break;
                default:
                    grade = "F - Reattemt";
            }
            System.out.println("Student " + (i + 1) + ": " + marks[i] + " - Grade " + grade);
        }
        System.out.println("\nHighest Mark: " + highest);
        sc.close();
    }
}