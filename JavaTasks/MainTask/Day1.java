
	import java.util.Scanner;
	public class Calculator {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter first integer: ");
	        int num1 = scanner.nextInt();
	        System.out.print("Enter operator (+, -, *, /): ");
	        char operator = scanner.next().charAt(0);
	        System.out.print("Enter second integer: ");
	        int num2 = scanner.nextInt();
	        int result;
	        switch (operator) {
	        case '+':
	                result = num1 + num2;
	                System.out.println("Result: " + result);
	                break;
	            case '-':
	                result = num1 - num2;
	                System.out.println("Result: " + result);
	                break;
	            case '*':
	                result = num1 * num2;
	                System.out.println("Result: " + result);
	                break;
	            case '/':
	                   result = num1 / num2;  
	                    System.out.println("Result: " + result);
	                System.out.println("Invalid operator.");
	                break;
	        }
	        scanner.close();
	    }
	}
