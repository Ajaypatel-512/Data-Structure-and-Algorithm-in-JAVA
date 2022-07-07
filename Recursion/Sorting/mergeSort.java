package Recursion.Sorting;

import java.util.Arrays;
/**
 * Total levels = log N
 * at each level N no. of comparison are made.  hence
 * Time complexity  = O(N log N)
 * Space complexity = Auxiliary space = maximum elements resides in stack = maximum height of level i.e N
 *
 *
 *
 * **/
public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        int[] ans = MergeSort(arr);
        System.out.println(Arrays.toString(ans));

    }

    private static int[] MergeSort(int[] arr) {
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = MergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] mix = new int[left.length+right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i<left.length && j<right.length){
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        //add all remaining elements of array
        while (i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            mix[k] = right[j];
            j++;
            k++;
        }
        return mix;
    }
}

