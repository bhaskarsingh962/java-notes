import java.util.Scanner;

public class Main {
  public static void main (String[] args){  
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your roll");
    int roll = sc.nextInt();
    String name = sc.next();
    System.out.println("your roll is "+roll + "and name is "+ name);
  } 
}