import java.util.*;


class Stackk{
   Queue<Integer>q1;
   Queue<Integer>q2;
   Stack<Integer>st = new Stack<>();

   public Stackk(){
     q1 = new LinkedList<>();
     q2 = new LinkedList<>();
   }

   public void push(int x){
     while(!q1.isEmpty()){
        q2.add(q1.peek());
        q1.poll();
     }
     st.
     q1.add(x);
    while(!q2.isEmpty()){
        q1.add(q2.peek());
        q2.poll();
     }
   }

   public int pop(){
    int ans = q1.poll();
    return ans;
   }

   public int top(){
    if(!q1.isEmpty()) return q1.peek();
    System.out.println("empty");
    return -1;
   }

   public void display(){
    if(q1.size() == 0){
        System.out.println("stack is empty");
    }
    while(!q1.isEmpty()){
      System.out.println("first");
      System.out.println(q1.peek());
      q1.poll();
    }

   }


}


public class queuetostack {
    public static void main(String[] args) {
        Stackk st = new Stackk();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
       // st.display();
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
    }
}
