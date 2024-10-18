package Arrayss.subArrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumBitwiseORSubsets {

    /**
     * 2044. Count Number of Maximum Bitwise-OR Subsets
     *
     * Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.
     *
     * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.
     *
     * The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
     *
     * Example 1:
     *
     * Input: nums = [3,1]
     * Output: 2
     * Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
     * - [3]
     * - [3,1]
     * Example 2:
     *
     * Input: nums = [2,2,2]
     * Output: 7
     * Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
     * Example 3:
     *
     * Input: nums = [3,2,1,5]
     * Output: 6
     * Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
     * - [3,5]
     * - [3,1,5]
     * - [3,2,5]
     * - [3,2,1,5]
     * - [2,5]
     * - [2,1,5]
     * */

    public static void main(String[] args) {
        int[] arr = {2,2,2};
        System.out.println(countMaxOrSubsets2(arr));
    }

    //Solution 1 O(2^N)
    public static int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for (int num: nums){
            maxOR |= num;
        }

        int currOR = 0;
        return countSubsets(0,currOR,nums,maxOR);

    }

    private static int countSubsets(int idx, int currOR, int[] nums, int maxOR) {
        if (idx == nums.length){
            if (currOR == maxOR){
                return 1;
            }
            return 0;
        }

        int takeCount = countSubsets(idx+1,currOR | nums[idx], nums, maxOR);

        int notTakeCount = countSubsets(idx+1,currOR, nums, maxOR);

        return takeCount + notTakeCount;
    }


    //Solution 2 Using Memoization for duplicate visits O(n * maxOR) O(n * maxOR)
    public static int countMaxOrSubsets2(int[] nums) {
        int maxOR = 0;
        for (int num: nums){
            maxOR |= num;
        }

        int n = nums.length;
        int[][] t = new int[n + 1][maxOR + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxOR; j++) {
                t[i][j] = -1;
            }
        }

        int currOR = 0;
        return countSubsets2(0,currOR,nums,maxOR,t);

    }

    private static int countSubsets2(int idx, int currOR, int[] nums, int maxOR,int[][] t) {
        if (idx == nums.length){
            if (currOR == maxOR){
                return 1;
            }
            return 0;
        }

        if (t[idx][currOR] != -1){
            return t[idx][currOR];
        }

        int takeCount = countSubsets2(idx+1,currOR | nums[idx], nums, maxOR,t);

        int notTakeCount = countSubsets2(idx+1,currOR, nums, maxOR,t);

        return t[idx][currOR] = takeCount + notTakeCount;
    }
}
