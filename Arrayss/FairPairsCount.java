package Arrayss;

import java.util.Arrays;

public class FairPairsCount {

    /**
     * 2563. Count the Number of Fair Pairs
     * Attempted
     * Medium
     * Topics
     * Companies
     * Hint
     * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
     *
     * A pair (i, j) is fair if:
     *
     * 0 <= i < j < n, and
     * lower <= nums[i] + nums[j] <= upper
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
     * Output: 6
     * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
     * Example 2:
     *
     * Input: nums = [1,7,9,2,5], lower = 11, upper = 11
     * Output: 1
     * Explanation: There is a single fair pair: (2,3).
     * */

    public static void main(String[] args) {
        int[] num = {0,1,7,4,4,5};
        int lower = 3;
        int upper = 6;

        System.out.println(countFairPairs2(num,lower,upper));
    }

    //Solution 1 O(n^2) O(1)
    public static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;

        int count=0;
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                int sum = nums[i] + nums[j];
                if (sum>=lower && sum<=upper){
                    count++;
                }
            }
        }
        return count;
    }

    //Solution 2
    //O(n*lon) O(1)
    public static long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int l = lower - nums[i];
            int u = upper - nums[i];

            int l1 = lowerBound(nums, l, i + 1);
            int u1 = upperBound(nums, u, i + 1);

            ans += (u1 - l1);
        }

        return ans;
    }

    // Custom lowerBound function
    private static int lowerBound(int[] nums, int value, int start) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Custom upperBound function
    private static int upperBound(int[] nums, int value, int start) {
        int low = start, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
