package Linear_Search;

import java.util.Arrays;
import java.util.Scanner;

public class lsearch_range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TIME COMPLEXITY
        // Best Case = O(1)
        // Worst Case =O(n)

        int[] arr = {1, 4, 6, 22, 9, 22, 88, 432, 78, 7};
        System.out.println(Arrays.toString(arr));

        System.out.println("Enter the element to find in array");
        int target = sc.nextInt();
        System.out.println("Enter start and end index");
        int start = sc.nextInt();
        int end = sc.nextInt();
        int ans = lsearch(arr, target,start,end);
        System.out.println("Element find at index "+ans);
//        System.out.println(lsearch(arr,target,start,end));

    }

//    static boolean lsearch(int[] arr, int target, int a, int b) {
//        if (arr.length == 0) {
//            return false;
//        }
//        for (int i = a; i < b; i++) {
//            if(arr[i] == target){
//                return true;
//            }
//        }
//        return false;
//    }
    static int lsearch(int[] arr,int target,int a, int b) {
        if(arr.length == 0){
            return -1;
        }

        for(int i=a; i<b; i++) {
            int element = arr[i];
            if (element == target) {
                return i;
            }
        }
        return -1;
    }
}
