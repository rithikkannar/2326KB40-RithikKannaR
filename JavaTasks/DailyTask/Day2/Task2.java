package Day2;
import java.util.*;


public class Task2 {
	
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter A Sentence");
		String str=sc.nextLine();	
		str.toLowerCase();
		int c=0, v=0;
		for(int i=0;i<str.length();i++) {
			char A=str.charAt(i);
			if(A=='a'||A=='e'||A=='i'||A=='o'||A=='u') {
				v++;
			}
			else {
				c++;
			}}
		System.out.println("VOWELS : "+v);
		System.out.println("CONSONANTS : "+c);
		}}