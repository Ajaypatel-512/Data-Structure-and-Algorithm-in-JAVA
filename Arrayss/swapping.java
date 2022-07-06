package Arrayss;

import java.util.Arrays;

public class swapping {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 84};
        swap(arr, 2, 4);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
}
