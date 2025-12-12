package left;
import java.util.*;

public class string {
   public static String reverse(String str){
     StringBuilder sb = new StringBuilder(str);
     int n = str.length();
     int i = 0;
     int j = n-1;
     while(i < j){
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
        i++;
        j--;
     }
     str = "";
     for(i=0;i<n;i++){
       str += sb.charAt(i);
     }

     return str; 
   }
   
   public static void main(String[] args) {
    String str  = "bhaskar";
    System.out.println(reverse(str));
   }
}
