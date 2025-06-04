package Binary_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthMissingPositiveNumber {
    /**
     * 1539. Kth Missing Positive Number
     * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
     *
     * Return the kth positive integer that is missing from this array.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [2,3,4,7,11], k = 5
     * Output: 9
     * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
     * Example 2:
     *
     * Input: arr = [1,2,3,4], k = 2
     * Output: 6
     * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 1000
     * 1 <= arr[i] <= 1000
     * 1 <= k <= 1000
     * arr[i] < arr[j] for 1 <= i < j <= arr.length
     *
     *
     * Follow up:
     *
     * Could you solve this problem in less than O(n) complexity?
     * */
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(findKthPositive(arr, k)); // Output: 9

        arr = new int[]{1, 2, 3, 4};
        k = 2;
        System.out.println(findKthPositive(arr, k)); // Output: 6
    }

    //Solution 1: Brute Force
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) k++;
            else break;
        }
        return k;
    }

    //Solution 2: Binary Search
    //Time Complexity: O(log n)
    //Space Complexity: O(1)
    public static int findKthPositiveBinarySearch(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

}
