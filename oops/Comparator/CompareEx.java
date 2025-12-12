package oops.Comparator;

import java.util.Comparator;

public class CompareEx implements Comparator<Integer>{
   public int compare(Integer a, Integer b){
     return b-a;
   }
}
