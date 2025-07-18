import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int[][] arr  = new int[3][3];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
              arr[i][j] = sc.nextInt(); 
            }
        }

        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[i].length;j++){
        //       System.out.print(arr[i][j]+" "); 
        //     }
        //     System.out.println();
        // }

        // for(int[] a: arr){
        //     System.out.println(Arrays.toString(a));
        // }

        //  for(int i=0;i<arr.length;i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
    }
}