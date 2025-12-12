import java.util.ArrayList;

class Graph {
    int n = 5;
    int m = 5;
    ArrayList<ArrayList<Integer>>li = new ArrayList<>();
    for(int i=0;i<n;i++){
      li.add(new ArrayList<>());
    }
    li.get(1).add(1);
    li.get(1).add(2);

    li.get(3).add(5);
    li.get(3).add(4);

    li.get(4).add(6);
    li.get(4).add(7);
}


public class Create {
   public static void main(String[] args) {
      
   }
}
