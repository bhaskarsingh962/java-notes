package oops.polymorphismDemo;

class EarlyBinding{
//    public int sum(int a, int b){
//     return a+b;
//    }

   public double sum(int a, double b){
    return b+a;
   }

//    public double sum( double a, int b){ 
//     return b+a;
//    }

   public double sum(int a, int b, int c){
    return b+a+c;
   }
} 

public class Compile {
    public static void main(String[] args) {
       EarlyBinding e = new EarlyBinding();
       System.out.println(e.sum(4,5)); // this will create ambiquty if int int type not persent compiler will confused which method to call becouse they will treat as same
       System.out.println(e.sum(3, 5, 6));
       System.out.println(e.sum(8, 9.7)); 
      // System.out.println(e.sum(8.3, 9)); 
    }
}
