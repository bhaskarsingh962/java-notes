package oops.singleton;
import java.util.*;

import org.xml.sax.SAXException;


//1- way of making singleton class
// class SingleTon{
//     private static final SingleTon sn = new SingleTon();
//     private SingleTon(){}

//     public static SingleTon getInstence(){
//         return sn;
//     }
//     public void method(){
//         System.out.println("single method");
//     }
// }



// 2-way
// class SingleTon{
//     private static SingleTon instence;
//     private SingleTon(){}

//     public static synchronized SingleTon getInstence(){
//         if(instence == null){
//             instence = new SingleTon();
//         }
//         return instence;
//     }

//     public void method(){
//         System.out.println("you can only make one instence");
//     }
// }



//Double-Checked Locking
class SingleTon{
    private static volatile SingleTon instence;
    private SingleTon(){}

    public static SingleTon getInstence(){
        if(instence == null){
            synchronized(SingleTon.class){
                if(instence == null){
                    instence = new SingleTon();
                }
            }
            
        }
        return instence;
    }

    public void method(){
        System.out.println("you can only make one instence");
    }
}


public class main {
   public static void main(String[] args) {
    //  SingleTon.getInstence().method(); 
    SingleTon t1 = SingleTon.getInstence();
    SingleTon t2 = SingleTon.getInstence();
    t1.method();
    t2.method();
    System.out.println(t1==t2);
   } 
}
