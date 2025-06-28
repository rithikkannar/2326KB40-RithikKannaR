//import java.util.Scanner;
//public class AddressBook {
//    public static void main(String[] args) {
//        Scanner obj = new Scanner(System.in);
//        System.out.print("Enter the number of Persons ");
//        int n = obj.nextInt();
//        
//        obj.nextLine();
//        for(int i = 0 ; i<n;i++)
//        {
//        	System.out.println("Enter The Person Name");
//        	String sentence = obj.nextLine();
//        	System.out.println("Enter The Address");
//        	String address=obj.nextLine();
//        	String[] details =
//        	
//        }
//        
//    }}
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int per = sc.nextInt();
        sc.nextLine(); 
        String[] names = new String[per];
        String[] addresses = new String[per];
        for (int i = 0; i < per; i++) {
            System.out.print("Enter name: ");
            names[i] = sc.nextLine();
            System.out.print("Enter address: ");
            addresses[i] = sc.nextLine();
        }
        System.out.println("\nStored Address Book:");
        for (int i = 0; i < per; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.println("Name: " + names[i]);
            System.out.println("Address: " + addresses[i]);
        }

        sc.close();
    }
}
