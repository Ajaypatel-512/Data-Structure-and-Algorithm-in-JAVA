package MathsNumSys;

public class LongestNiceSubarray {
    /**
     * 2401. Longest Nice Subarray
     * You are given an array nums consisting of positive integers.
     *
     * We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.
     *
     * Return the length of the longest nice subarray.
     *
     * A subarray is a contiguous part of an array.
     *
     * Note that subarrays of length 1 are always considered nice.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,8,48,10]
     * Output: 3
     * Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
     * - 3 AND 8 = 0.
     * - 3 AND 48 = 0.
     * - 8 AND 48 = 0.
     * It can be proven that no longer nice subarray can be obtained, so we return 3.
     * Example 2:
     *
     * Input: nums = [3,1,5,11,13]
     * Output: 1
     * Explanation: The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * */
    public static void main(String[] args) {
        int[] nums = {1,3,8,48,10};
        System.out.println(longestNiceSubarray(nums));
    }

    //Solution 1 - Using Brute Force
    //Time Complexity - O(n^2 * n)
    //Space Complexity - O(1)
    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                if (isNice(nums,i,j)){
                    result = Math.max(result,j-i+1);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isNice(int[] nums, int start, int end) {
        int mask = 0;
        for (int i = start; i <= end; i++){
            if ((mask&nums[i]) != 0){
                return false;
            }
            mask = mask | nums[i];
        }
        return true;
    }

    //Solution 2 - Using Better Approach
    //Time Complexity - O(n^2)
    //Space Complexity - O(1)
    public static int longestNiceSubarray2(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i=0; i<n; i++){
            int mask=0;
            for (int j=i; j<n; j++){
                if((mask & nums[j]) != 0) {
                    break;
                }

                result = Math.max(result, j - i + 1);
                mask = (mask | nums[j]);
            }
        }
        return result;
    }

    //Solution 3 - Using Sliding Window Approach
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int longestNiceSubarray3(int[] nums) {
        int n = nums.length;
        int result = 0;
        int mask=0;
        int i=0;
        int j=0;

        while (j<n){
            while ((mask & nums[j]) != 0){
                mask = (mask ^ nums[i]);
                i++;
            }
            result = Math.max(result,j-i+1);
            mask = (mask | nums[j]);
            j++;
        }
        return result;
    }
}
