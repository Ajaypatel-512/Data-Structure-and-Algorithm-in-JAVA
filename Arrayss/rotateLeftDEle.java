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

    //Solution 1: Brute force
    //Time Complexity: O(N*D) where N is the size of the array and D is the number of rotations
    // Space Complexity: O(1)
    static void leftRotate(int[] arr, int n){
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }

    static void rotate1(int[] arr,int n,int d){
        for(int i=0; i<d; i++)
            leftRotate(arr,n);
    }

    //Solution 3: Better approach
    //Time Complexity: O(N*D) where N is the size of the array and D is the number of rotations
    // Space Complexity: O(D)
    static void rotate2(int[] arr,int n,int d){
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < n; i++) {
            arr[i-d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[n-d+i] = temp[i];
        }
    }


    //Solution 3: Optimal approach
    //Time Complexity: O(N) where N is the size of the array
    // Space Complexity: O(1)
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
