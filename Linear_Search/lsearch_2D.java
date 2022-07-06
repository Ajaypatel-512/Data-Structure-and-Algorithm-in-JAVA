package Linear_Search;

import java.util.Arrays;
import java.util.Scanner;

public class lsearch_2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = {
                {1, 44, 66,},
                {678, 2, 0, -7},
                {11, 2, 89},
                {-2, 33, 16, 56, 100}
        };
        System.out.println("Enter elements to search ");
        int target = sc.nextInt();
        int[] ans = lsearch(arr,target);
        System.out.println("Element found at index "+Arrays.toString(ans));
//        System.out.println("Maximum value of arr : "+maxRange(arr,5, arr.length));
//        System.out.println("Maximum value of arr : "+minRange(arr,5, arr.length));
    }
    static int[] lsearch(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
