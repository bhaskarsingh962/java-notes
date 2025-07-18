import java.util.Arrays;
import java.util.Scanner;

public class array {
    public static void main(String[] args) {
    //  these are the array of premitive
        int[] arr = new int[8];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<8;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr)); 
    }
}
