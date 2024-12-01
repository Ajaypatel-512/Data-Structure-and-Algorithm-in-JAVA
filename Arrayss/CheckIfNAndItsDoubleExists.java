package Arrayss;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExists {
    /**
     * 1346. Check If N and Its Double Exist
     *
     * Given an array arr of integers, check if there exist two indices i and j such that :
     *
     * i != j
     * 0 <= i, j < arr.length
     * arr[i] == 2 * arr[j]
     *
     *
     * Example 1:
     *
     * Input: arr = [10,2,5,3]
     * Output: true
     * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
     * Example 2:
     *
     * Input: arr = [3,1,7,11]
     * Output: false
     * Explanation: There is no i and j that satisfy the conditions.
     *
     *
     * Constraints:
     *
     * 2 <= arr.length <= 500
     * -103 <= arr[i] <= 103
     * */
    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        System.out.println(checkIfExist2(arr));
    }

    //Solution 1 Using Brute Force
    //T.C : O(n^2)
    //S.C : O(1)
    public static boolean checkIfExist(int[] arr) {
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (i != j && arr[i] == 2* arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //Solution 2 Using Set/Map
    //T.C : O(n)
    //S.C : O(n)
    public static boolean checkIfExist2(int[] arr) {
        Set<Integer> temp = new HashSet<>();

        for (int i=0; i<arr.length; i++){
            int num = arr[i]*2;
            if (temp.contains(num)){
                return true;
            } else if (arr[i] % 2 == 0 && temp.contains(arr[i] / 2)) {
                return true;
            }
            temp.add(arr[i]);
        }
        return false;
    }

    //Solution 3 Using Binary Search
    //T.C : O(nlogn)
    //S.C : O(1)
    public static boolean checkIfExist3(int[] arr) {
        Arrays.sort(arr);

        for (int i=0; i<arr.length; i++){
            int j = bSearch(arr, 2 * arr[i]);
            if (j != -1 && j != i) {
                return true;
            }
        }
        return false;
    }

    public static int bSearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
