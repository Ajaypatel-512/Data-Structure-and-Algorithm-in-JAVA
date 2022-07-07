package Recursion.Sorting;

import java.util.Arrays;

public class inPlaceMergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        MergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void MergeSort(int[] arr,int s,int e) {
        if(e - s == 1){
            return;
        }
        int mid = (s+e)/2;
        MergeSort(arr,s,mid);
        MergeSort(arr,mid,e);
        merge(arr,s,mid,e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e-s];

        int i = s;
        int j = m;
        int k = 0;

        while (i<m && j<e){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        //add all remaining elements of array
        while (i < m){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }

    }
}
