 package oops.exceptionHandling;


//how to make custom exception

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // pass message to parent class Exception
    }
}

class Voter {
    public void checkEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote");
        } else {
            System.out.println("You are eligible to vote!");
        }
    }
}


public class main {
    public static void main(String[] args) {
        Voter voter = new Voter();
        try {
            voter.checkEligibility(16); // custom exception will be thrown
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Program executed successfully!");
        }
    }
}








//1- //checked
// class exception {

//     public int method() throws IOException {
//         FileReader fr = new FileReader("abc.txt");
//         fr.read();
//         fr.close();
//         return 1;
//     }
// }


// public class main {
//     public static void main(String[] args) {
//         exception ex = new exception();
//         try {
//             ex.method();
//         } catch (IOException e) {
//             System.out.println("Handled in main: " + e.getMessage());
//         }
//     }
// }







//2- without throw how can we handle it
// class exception {
 //checked exception  
//     public int method(){ 
//         int ans = 0;
//         try {
//             FileReader fr = new FileReader("abc.txt"); // may throw FileNotFoundException
//             fr.read();                                 // may throw IOException
//             fr.close();
//         } catch (FileNotFoundException e) {
//             System.out.println("File not found: " + e.getMessage());
//         } catch (IOException e) {
//             System.out.println("IO error occurred: " + e.getMessage());
//         } finally {
//             System.out.println("Finally block executed");
//         }
//         return ans;
//     }

//     public int method1(){
//        int ans = 1;  
//        return ans;
//     }
// }






 
// class exception {
//    
//     public int method(int a, int b) throws Exception{ 
//        int ans = 0;      
//        if(b==0){
//         throw new Exception("divide by zero");
//        }else{
//         ans = a/b; 
//        }
//        return ans;
//     }

//     public int method1(){
//        int ans = 1;  
//        return ans;
//     }
// }


// public class main {
//     public static void main(String[] args) {
//         exception ex = new exception();
//         try {
//             System.out.println( ex.method(3,0) + " "+"hey bro whatsap finally you are back");
//         }catch (ArithmeticException e) {
//             System.out.println(e.getMessage());
//         }catch (Exception e) {
//             System.out.println(e.toString());
//         }finally{
//             System.out.println("fianlly i have learnt how to use it");
//         }

//         // exception ex1 = new exception();
//         // System.out.println( ex1.method1() );
//     }
// }

