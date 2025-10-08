package oops.polymorphismDemo;


class CarLatebinding{
  
  String Brand ;  

  public CarLatebinding(String Brand){
    this.Brand = Brand;
  }
  
  public void speed(){
    System.out.println("this is normal speed");
  }

  public void Carmethod(){
    System.out.println("CarLatebinding method");
  }
}

class Bmw extends CarLatebinding{
    
    public Bmw(String Brand){
        super(Brand);
    }

//     public void speed(){
//     System.out.println("BMW speed");
//    }

   public void race(){
    System.out.println("BMW race");
   }
}


public class Runtime {
    public static void main(String[] args) {
      Bmw b1 = new Bmw("tata"); //this happens in compile time
      b1.speed();
      CarLatebinding b2 = new Bmw("tata");
      b2.speed();
      Bmw b = (Bmw)b2;
      b.race(); //you can access only those method by object variable of paremt whch are override by child or persent in chaild
      b2.Carmethod();

    //downcasting
      CarLatebinding c = new CarLatebinding("tata");
      Bmw b3 = (Bmw)c;
       b3.speed();
       b3.race();
       b3.Carmethod();
    }
}
