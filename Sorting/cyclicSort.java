package Sorting;

import java.util.Arrays;

/**CYCLIC SORTING ALGORITHM
 * when given numbers from range 1 to n use cyclic sort (imp)
 * eg = 3 5 2 1 4
 *      1 2 3 4 5   (index = value - 1) (swapps = n-1  swapp = n  total_swapp = n-1 + n = 2n-1)
 *      approach
 *      swapp 0 index value to its item position 2 5 3 1 4 (check 0 index value is correct if yes move pointer forward else agar swap)
 *      swapp 0 index value to its item position 5 2 3 1 4 (check 0 index value is correct if yes move pointer forward else agar swap)
 *      swapp 0 index value to its item position 4 2 3 1 5 (check 0 index value is correct if yes move pointer forward else agar swap)
 *      swapp 0 index value to its item position 1 2 3 4 5 (check 0 index value is correct if yes move pointer forward else agar swap)
 *      pointer++ check 1 index value == its position if yes move pointer else swapp
 *      pointer++ check 2 index value == its position if yes move pointer else swapp
 *      pointer++ check 3 index value == its position if yes move pointer else swapp
 *      pointer++ check 4 index value == its position if yes move pointer else swapp
 *      pointer++ check 5 index value == its position stop.
 *
 *  {
 *      TIME COMPLEXITY - O(n)
 *      SPACE COMPLEXITY - O(1)
 *  }
 *
**/
public class cyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        CycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void CycleSort(int[] arr){
        int temp = 0;
        int i = 0;
        while(i<arr.length) {
            int correct_index = arr[i] - 1;
            if (arr[i] != arr[correct_index]) {
                swappArray(arr, i, correct_index);
            }else {
                i++;
            }
        }
    }

    static void swappArray(int[] arr,int first, int second){
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
