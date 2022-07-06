package Arrayss;

import java.util.Arrays;

public class Array2DSearch {
    public static void main(String[] args) {
//        int[][] arr = {
//                {10,20,30,40},
//                {15,25,35,45},
//                {28,29,37,49},
//                {33,34,38,50}
//        };
        int[][] arr = {
                {-1,3}
        };
        System.out.println(Arrays.toString(search(arr,3)));
    }
    public static int[] search(int[][] arr, int target){
        int r = 0;
        int c = arr[0].length-1;

//        if(arr.length == 1){
//            r = 0;
//            c = 0;
//        }
        while (r < arr.length && c>=0){
            if(arr[r][c] == target){
                return new int[]{r,c};
            }
            if(arr[r][c] < target){
                r++;
            }
            else{
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
