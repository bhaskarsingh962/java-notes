package oops.Inheritance;

public class Main {
    public static void main(String[] args) {
       String child = "meraa beta";
       String parent = "singh";   
       Child p1 = new Child(child, parent);
       Parent p = new Parent();
       p.parent();
       p1.parent();
       Child p1 = new Parent();
       Parent p2 = new Child(child, parent);
       p2.parent();
       p2.child();
       //p.child(); only child class can access all upper clasess method not parent class
       p1.child();
       System.out.println(p1.parent1);
       System.out.println(p1.child1);
    }
}
