package oops.Inheritance;

public class Main {
    public static void main(String[] args) {
       String child = "meraa beta";
       String parent = "bhaskar singh";   
       Child p1 = new Child(child, parent);
       System.out.println(p1.parent1);
       System.out.println(p1.child1);
    }
}
