package Sorting;

import java.util.Arrays;
/** TIME COMPLEXITY -

 * Worst Case - O(N^2)
 * Best Case - O(N)

 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,4,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped;
        for (int i=0; i<= n-1; i++) {
            swapped = false;
            for (int j = 1; j <= n - i - 1; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    //Time complexity - O(N^2) worst case when array is reverse sorted or not sorted
    //Space complexity - O(1)
    public static void bubbleSort2(int[] arr){
        int n = arr.length;
        for (int i=n-1; i>=0; i--){
            for (int j=0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //Time complexity - O(N) Best case when array is already sorted
    //Space complexity - O(1)
    public static void bubbleSort3(int[] arr){
        int n = arr.length;
        for (int i=n-1; i>=0; i--){
            boolean swapped = false;
            for (int j=0; j<=i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }
}
