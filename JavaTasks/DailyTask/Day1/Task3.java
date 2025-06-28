package Day1;
import java.util.Scanner;
public class Task3{
public static void main( String args [] ){
Scanner year=new Scanner (System.in);
System.out.println("Enter The year");
int Yr=year.nextInt();
if(Yr%4==0 && Yr%100!=0 || Yr%400==0)
System.out.println("It is a leap year");
else
System.out.println("It is not a Leap year");
}}