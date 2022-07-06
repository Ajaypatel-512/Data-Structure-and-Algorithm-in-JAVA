package Arrayss;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

//        int[] arr = new int[n];
//        for(int i=0; i<arr.length; i++){
//            arr[i] = sc.nextInt();
//        }
//        for(int i=0; i<arr.length; i++){
//            System.out.println(arr[i]);
//        }
//        System.out.println(Arrays.toString(arr));

//        for (int row=0; row<arr.length; row++){
//            for (int col=0; col<arr[row].length; col++){
//                arr[row][col] = sc.nextInt();
//            }
//        }
        int[][] arr ={
                {1,2,3},
                {2,4},
                {5,1,6,7}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

//        for (int[] arr1:arr) {
//            System.out.println(Arrays.toString(arr1));
//        }
        
//        for(int i=0; i<arr.length; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }

    }
}
