package Arrayss;

import java.util.Arrays;

public class Reverse_Arr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,7};

        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while (start<end){
            swap(arr,start,end);
            start++; 
            end--;
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
