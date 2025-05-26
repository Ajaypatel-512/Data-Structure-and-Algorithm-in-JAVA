package Arrayss;

public class RotateRightByDElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2; // Number of positions to rotate
        int n = arr.length;
        rotate(arr, n, d);
        System.out.println(java.util.Arrays.toString(arr));
    }

    //Solution 1: Brute force
    //Time Complexity: O(N*D) where N is the size of the array and D is the number of rotations
    // Space Complexity: O(1)
    static void rightRotate(int[] arr, int n){
        int temp = arr[n - 1];
        for (int i = n-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    private static void rotate1(int[] arr,int n,int d){
        for(int i=0; i<d; i++)
            rightRotate(arr,n);
    }

    //Solution 2: Better approach
    //Time Complexity: O(N*D) where N is the size of the array and D is the number of rotations
    // Space Complexity: O(D)
    private static void rotate2(int[] arr,int n,int d){
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[n-d+i];
        }

        for (int i = d; i < n; i++) {
            arr[i] = arr[i-d];
        }

        for (int i = 0; i < d; i++) {
            arr[i] = temp[i];
        }
    }


    //Solution 3: Optimal approach
    //Time Complexity: O(N) where N is the size of the array
    // Space Complexity: O(1)
    static void rotate(int[] arr,int n,int d){
        reverse(arr,0,n-d-1);
        reverse(arr,n-d,n-1);
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
