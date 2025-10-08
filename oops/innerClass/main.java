package oops.innerClass;


//3 - anonymouse class
interface Animal{
    
   public int a = 10;
   abstract public void sound();
   public static void method (){
    System.out.println("this is method");
   }

}


public class main {
    public static void main(String[] args) {
        Animal dog = new Animal() {
          public void sound(){
            System.out.println("this is sound of Dog");
          }   
        };
      dog.sound();  
      Animal.method();
    }
}









// //3 - inner class inside method
// class Outer{
    
//    public int a = 10;
   
//    public void method(){
//     int ammount = 1000;
    
//     class Inner{
//       public void inner(){
//         System.out.println("your ammount is "+""+ammount);
//       }
//      }

//     Inner i = new Inner();
//     i.inner();
//    }

// }


// public class main {
//     public static void main(String[] args) {
//         Outer i = new Outer();
//         i.method();
//     }
// }








// 2- static inner class
// class Outer{
    
//    public static int a = 10;
//    static class Inner{
//       public static int a = 11;
//       public void inner(){
//         System.out.println("this is  inner class");
//         System.out.println(a);
//       }
//    }

// }


// public class main {
//     public static void main(String[] args) {
//         Outer.Inner i = new Outer.Inner();
//         i.inner();
     
//     }
// }






// 1- this is the "non static inner class instance class" 
// class Outer{
// //    public int a = 10;
   
   
//    class Inner{
//       public int a = 11;
//       public void inner(){
//         System.out.println("this is  inner class");
//         System.out.println(a);
//       }
//    }

//    public void outer(){
//     Inner i = new Inner();
//     System.out.println("this is outer");
//     System.out.println(i.a); //this is the way to access inner class instance in outer class
//    }
// }


// public class main {
//     public static void main(String[] args) {
//         Outer.Inner i = new Outer().new Inner();
//         i.inner();
//         Outer o = new Outer();
//         o.outer();
//     }
// }
