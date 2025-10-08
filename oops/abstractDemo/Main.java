package oops.abstractDemo;


abstract class Car {

   public String Brand; 
   public Car(String Brand){
     this.Brand = Brand;
   }

   public void method(){
    System.out.println("this is abstract class method");
   }

   public String getBrand(){
     return Brand;
   }

   public abstract void carName();

   public static void methodStatic(){
    System.out.print("this is static method");
   }
}


class Thar extends Car{
   public String carName;
    public Thar(String Brand) {
        super(Brand);
    }

    public Thar(String Brand, String carName) {
        super(Brand);
        this.carName = carName;
    }  

   @Override 
   public void method(){
    System.out.println("this is abstract class method");
   }

   public void carName(){
     System.out.println("car name -"+""+carName);
   }

   public static void methodStatic(){
    System.out.print("this is static method");
   }
}


public class Main {
    public static void main(String[] args) {
        Thar t = new Thar("tata","thar");
        Thar t1 = new Thar("thar");
        t.method();
        t.carName();

        System.out.println("this is the brand - " +""+t.Brand);
    }
}
