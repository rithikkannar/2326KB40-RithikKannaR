package Day2;
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        System.out.println("\nWords in the sentence:");
        	for (int i = 0;i<words.length;i++) {	
            System.out.println(words[i]);
        }}}