package Arrayss;

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated {
    /**
     * 1752. Check if Array Is Sorted and Rotated
     * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
     *
     * There may be duplicates in the original array.
     *
     * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,4,5,1,2]
     * Output: true
     * Explanation: [1,2,3,4,5] is the original sorted array.
     * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
     * Example 2:
     *
     * Input: nums = [2,1,3,4]
     * Output: false
     * Explanation: There is no sorted array once rotated that can make nums.
     * Example 3:
     *
     * Input: nums = [1,2,3]
     * Output: true
     * Explanation: [1,2,3] is the original sorted array.
     * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     * */
    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        System.out.println(check(nums));
    }

    //Solution 1 : Brute Force
    //Time complexity: O(n^2)
    //Space complexity: O(n)
    public static boolean check(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        for (int num : nums) {
            rotateByOne(nums);
            if (Arrays.equals(nums, temp))
                return true;
        }

        return false;
    }

    public static void rotateByOne(int[] arr) {
        if (arr.length <= 1) return;
        int last = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }


    //Solution 2 : Efficient
    //Time complexity: O(n^2)
    //Space complexity: O(1)
    public static boolean check2(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int r = 0; r < n; r++) {
            boolean isSorted = true;
            for (int i = 0; i < n; i++) {
                if (sorted[i] != nums[(i + r) % n]) {
                    isSorted = false;
                    break;
                }
            }

            if (isSorted) {
                return true;
            }
        }

        return false;
    }

    //Solution 3 : Efficient
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static boolean check3(int[] nums) {
        int n = nums.length;

        int peak = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                peak++;
            }
        }

        return peak <= 1;
    }

}
