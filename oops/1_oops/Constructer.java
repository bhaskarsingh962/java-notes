//for example making it for student
public class Constructer {

   String name = "rohan";
   int roll = 90;
   float sellary;

   Constructer(String name, int roll, float sellary){
      this.name = name;
      this.roll = roll;
      this.sellary = sellary;
   }
   
   public static void main(String[] args) {
     Constructer c1 = new Constructer("bhaskar", 78, 345);
     System.out.println(c1.roll);
   }
}

