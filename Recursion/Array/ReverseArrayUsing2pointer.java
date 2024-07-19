package Recursion.Array;

public class ReverseArrayUsing2pointer {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = 5;
        System.out.println("Before Reversing Array : " + arr);
        for (int i: arr){
            System.out.print(i +" ");
        }

        reverseArray(0, arr,n-1);
        System.out.println("\nAfter Reversing Array : " + arr);

        for (int i: arr){
            System.out.print(i +" ");
        }
    }

    public static void reverseArray(int l, int[] arr, int r){
        if (l >= r)
            return;

        swap(l,r,arr);
        reverseArray(l+1,arr,r-1);
    }

    private static void swap(int l, int r,int[] arr) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
