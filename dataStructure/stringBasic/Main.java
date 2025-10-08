package dataStructure.stringBasic;

import java.util.*;


public class Main{
   public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter String :");
     String s = sc.nextLine();
    //  System.out.println(s);
    //  System.out.println(s.toString());
     StringBuilder sb = new StringBuilder(s);
     sb.reverse();
     s = sb.toString();
     System.out.println(s);
     s.toLowerCase();
     for(int i=0;i<s.length();i++){
      if(s.charAt(i) < 'a' || s.charAt(i) > 'z'){
         System.out.println("string contain extra letters");
         break;
      }
     }
   }
}