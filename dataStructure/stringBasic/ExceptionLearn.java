package dataStructure.stringBasic;

import java.util.*;

class invalidLatterException extends Exception{
   public invalidLatterException(String s){
      super(s);
   }
}


class Test{
    String s;
    public Test(String name){
      this.s = name;
    }
    public void check()  throws invalidLatterException{
      for(int i=0;i<s.length();i++){
      if(!s.matches("[a-zA-Z]+")){
         throw new invalidLatterException("string contain extra letters");
      }
     }
    }
}


public class ExceptionLearn {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter your string");
       String s = sc.nextLine();
       sc.close();
       Test t = new Test(s);
       try {
          t.check();
       } catch (Exception e) {
          System.out.println(e);
       }finally{
          System.out.println("this is the final block");
       }
    }
}
