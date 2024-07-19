package Recursion.Array;

public class ReverseArrsyUsing1Pointer {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 5;
        System.out.println("Before Reversing Array : " + arr);
        for (int i: arr){
            System.out.print(i +" ");
        }

        reverseArray(0, arr,n);
        System.out.println("\nAfter Reversing Array : " + arr);

        for (int i: arr){
            System.out.print(i +" ");
        }
    }

    public static void reverseArray(int i, int[] arr, int n){
        if (i >= n/2)
            return;

        swap(i,n-i-1,arr);
        reverseArray(i+1,arr,n-i-1);
    }

    private static void swap(int l, int r,int[] arr) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
