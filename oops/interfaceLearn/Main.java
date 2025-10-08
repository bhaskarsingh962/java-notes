package oops.interfaceLearn;



interface Car {
  public void start();
  public void stop();
 
  public static final String nameOwner = "tata";
  public static String getName(){
    return nameOwner;
  } 

  default void method(){
    System.out.println("this is default method in car");
  }
}


class Scorpio implements Car{
  public void start(){
    System.out.println("scorpio is started");
  }
  public void stop(){
    System.out.println("scorpio is stoped");
  }
  
}

public class Main {
    public static void main(String[] args) {
        Scorpio s = new Scorpio();
        s.start();
        s.stop();
        s.method();
        System.out.println(Car.getName());

    }

}
