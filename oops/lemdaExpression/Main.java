package oops.lemdaExpression;


//this is using lemda function

public class Main {
    public static void main(String[] args){
      InterfaceLem i = () -> System.out.println("hey evryone");
       i.greeting();  
      }
  } 




//this is without lemda function

// public class Main {
//     public static void main(String[] args){
//       InterfaceLem i = new InterfaceLem() {
//          public void greeting(){
//           System.out.println("hey everyone");
//          }
//       };
//     } 
// }

