package dataStructure.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1,"bhaskar singh");
        mp.put(3, "aman");
        mp.put(2, "rahul");

        System.out.println(mp.get(2));
        System.out.println(mp.containsKey(3));
        System.out.println(mp.containsValue("rahul"));

        //  get key values use mp.get(key) to get values
        for(int i: mp.keySet()){
            System.out.println(i);
        }

        // to print values
        for(String i: mp.values()){
            System.out.println(i);
        }


        //to print key values pair
        Set<Map.Entry<Integer, String>>entry = mp.entrySet();

        for(Map.Entry<Integer, String>e : entry ){
          System.out.println(e.getKey() + " " + e.getValue().toUpperCase());
        }

        mp.remove(2);
        mp.remove(2, "ram"); // this will not remove anything becouse the value of key 2 is not a ram
    }
}









// time complaxity for evry operation is 0(1) constent time