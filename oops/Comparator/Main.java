package oops.Comparator;

import java.util.*;

public class Main {
   public static void main(String[] args) {
      // List<String>li = Arrays.asList("bhaskar", "Rohan", "shivam");
      // List<Integer> li1 = new ArrayList<>();
      // li1.add(2);
      // li1.add(0);
      // li1.add(1);
      // li1.add(3);
      // li1.sort((a,b) -> b-a);
      // System.out.println(li1);



      List<Result> Sort = new ArrayList<>(Arrays.asList(
         new Result("bhaskar", 18),
         new Result("aman", 16),
         new Result("ram", 14)
      ));

      Comparator<Result> r = (a ,b) -> b.name.length() - a.name.length();
      Collections.sort(Sort, r);
      System.out.println(Sort);

   }
}
