package Sorting;

import java.util.Arrays;

/** TIME COMPLEXITY -

 * Worst Case - O(N^2)
 * Best Case - O(N^2)

 * Unstable
 * best use in small list/arrays
 **/
public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {-2,-33,-2,0};
        Selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Selection(int[] arr){
        //two ways
        //1. select maximum element and swapped with its place similarly do for every elements
        //2. select minimum element and swapped with its place similarly do for every elements
        for (int i = 0; i < arr.length; i++) {
            //find max item and swapp with correct index
            int last = arr.length-i-1;
            int max = max(arr,0,last);
            swappArray(arr,max,last);
        }
    }

    static void swappArray(int[] arr,int first, int second){
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int max(int[] arr,int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }
}
