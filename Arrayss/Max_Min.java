package Arrayss;

public class Max_Min {
    public static void main(String[] args) {
        int[] arr = {1,44,66,-3,678,2,0,-7};
        System.out.println("Maximum value of arr : "+max(arr));
        System.out.println("Maximum value of arr : "+min(arr));
        System.out.println("Maximum value of arr : "+maxRange(arr,5, arr.length));
        System.out.println("Maximum value of arr : "+minRange(arr,5, arr.length));
    }
// work on edge cases like array being null, ...etc
    // end>start return -1
    // arr == null return -1
    // arr.length == 0 return -1

    static int minRange(int[] arr, int start, int end) {
        int min = arr[start];
        for (int i = start; i < end; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    static int maxRange(int[] arr, int start, int end) {
        int max = arr[start];
        for (int i = start; i < end; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
