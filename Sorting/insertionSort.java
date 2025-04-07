package Sorting;

import java.util.Arrays;
/** TIME COMPLEXITY -

 * Worst Case - O(N^2)
 * Best Case - O(N) when array is already sorted
 * Best Case - O(N)

 * Stable, Adaptive, used for smaller values of n works good in if array is partially sorted
   that's why it takes part in hybrid sorting algorithms
 **/
public class insertionSort {
    public static void main(String[] args) {
        int[] arr = {-2,-44,0,409,-99,00};
        Insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void Insertion(int[] arr){

        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swappArray(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }

    static void swappArray(int[] arr,int first, int second){
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
