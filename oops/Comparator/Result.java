package oops.Comparator;

public class Result {
    String name;
    int marks;

    public Result(String name, int marks){
      this.name = name;
      this.marks = marks;
    }

     public String toString() {
        return name + " - " + marks;
    }
}
