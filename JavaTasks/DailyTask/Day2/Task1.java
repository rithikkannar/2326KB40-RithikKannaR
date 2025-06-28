package Day2;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
       System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int i = n - 1; i >= 0; i--) {
           System.out.print(arr[i] + " ");
        }
}}
