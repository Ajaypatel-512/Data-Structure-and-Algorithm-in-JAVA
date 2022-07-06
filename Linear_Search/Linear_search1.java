package Linear_Search;

import java.util.Arrays;
import java.util.Scanner;

public class Linear_search1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TIME COMPLEXITY
        // Best Case = O(1)
        // Worst Case =O(n)

        int[] arr = {1,4,6,22,9,22,88,432,78,7};
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the element to find in array");
        int target = sc.nextInt();
//        int ans = lsearch(arr, target);
//        System.out.println("Element find at index "+ans);
        System.out.println(lsearch(arr,target));

    }

    static boolean lsearch(int[] arr, int target) {
        if(arr.length == 0){
            return false;
        }
        for (int element: arr) {
            if (element == target){
                return true;
            }
        }
        return false;
    }
//    static int lsearch(int[] arr,int target) {
//        if(arr.length == 0){
//            return -1;
//        }
//
//        for(int i=0; i<arr.length; i++) {
//            int element = arr[i];
//            if (element == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // return true or false only

}

