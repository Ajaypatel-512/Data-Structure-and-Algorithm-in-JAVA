package Arrayss.subArrays;

public class MaximumAbsoluteSumOfAnySubarray {
    /**
     * 1749. Maximum Absolute Sum of Any Subarray
     * You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
     *
     * Return the maximum absolute sum of any (possibly empty) subarray of nums.
     *
     * Note that abs(x) is defined as follows:
     *
     * If x is a negative integer, then abs(x) = -x.
     * If x is a non-negative integer, then abs(x) = x.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,-3,2,3,-4]
     * Output: 5
     * Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.
     * Example 2:
     *
     * Input: nums = [2,-5,1,-4,3,-2]
     * Output: 8
     * Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * */
    public static void main(String[] args) {
        int[] nums = {1,-3,2,3,-4};
        System.out.println(maxAbsoluteSum(nums));
    }

    //Solution 1 : Brute Force
    //Time Complexity : O(n^2)
    //Space Complexity : O(1)
    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += nums[j];
                max = Math.max(max,Math.abs(sum));
            }
        }
        return max;
    }

    //Solution 2 : Kadane's Algorithm
    //Time Complexity : O(n)
    //Space Complexity : O(1)
    public static int maxAbsoluteSum2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i : nums){
            sum += i;
            max = Math.max(max,sum);
            if (sum < 0){
                sum = 0;
            }
        }
        sum = 0;
        for (int i : nums){
            sum += i;
            min = Math.min(min,sum);
            if (sum < 0){
                sum = 0;
            }
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}
