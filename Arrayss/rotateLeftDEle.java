package Arrayss;

import java.util.Arrays;

public class rotateLeftDEle {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int d = 1;
        int n = arr.length;
        rotate(arr,n,d);
        System.out.println(Arrays.toString(arr));
    }

//    NAIVE APPROACH  O(N*D) O(1)
//    static void leftRotate(int[] arr, int n){
//        int temp = arr[0];
//        for (int i = 1; i < n; i++) {
//            arr[i-1] = arr[i];
//        }
//        arr[n-1] = temp;
//    }
//
//    static void rotate(int[] arr,int n,int d){
//        for(int i=0; i<d; i++)
//            leftRotate(arr,n);
//    }

//    BETTER APPROACH  O(N) O(D)
//    static void rotate(int[] arr,int n,int d){
//        int[] temp = new int[d];
//        for (int i = 0; i < d; i++) {
//            temp[i] = arr[i];
//        }
//
//        for (int i = d; i < n; i++) {
//            arr[i-d] = arr[i];
//        }
//
//        for (int i = 0; i < d; i++) {
//            arr[n-d+i] = temp[i];
//        }
//    }


    //    EFFICEIENT APPROACH  O(N) O(1)
    static void rotate(int[] arr,int n,int d){
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
    }
    static void reverse(int[] arr, int l, int h){
        while(l<h){
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
            l++;
            h--;
        }
    }

}
