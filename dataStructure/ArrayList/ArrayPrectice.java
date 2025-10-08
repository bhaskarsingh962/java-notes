package ArrayList;
import java.util.*;

public class ArrayPrectice {
    public static void main(String[] args){
        // int[] arr = new int[8];
        // Scanner in = new Scanner(System.in);
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = in.nextInt(); 
        // } 
        // for(int i=0;i<array.length;i++){
        //     System.out.print(array[i]+" ");
            
        // }
        // System.out.println();
        // for(int num : array){
        //     System.out.print(num + " ");
        // }

       // System.out.println(Arrays.toString(arr));
       


     // now making string array
    //  String[] str = new String[4];
    //  Scanner in = new Scanner(System.in);
    //     for(int i=0;i<str.length;i++){
    //         str[i] = in.next(); 
    //     }
    //     System.out.println(); 
    //     // for(int i=0;i<str.length;i++){
    //     //     System.out.println(str[i]+" "); 
    //     // }

    //   System.out.println(Arrays.toString(str));
    // }

    //multidirection array
    int[][] arr2 = new int[3][3];
    Scanner in = new Scanner(System.in);

    for(int i=0;i<arr2.length;i++){
        for(int j=0;j<arr2[i].length;j++){
          arr2[i][j] = in.nextInt();
        }
    }

    // for(int i=0;i<arr2.length;i++){
    //     for(int j=0;j<arr2[i].length;j++){
    //         System.out.print(arr2[i][j]+" ");
    //     }
    //     System.out.println();
    // }

    for(int[] num : arr2){
        System.out.println(Arrays.toString(num));
    }
    for(int[] num : arr2){
        System.out.println(num + " ");
    }
    }
}
