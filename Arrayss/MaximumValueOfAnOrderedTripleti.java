package Arrayss;

public class MaximumValueOfAnOrderedTripleti {
    /**
     * 2873. Maximum Value of an Ordered Triplet I
     * You are given a 0-indexed integer array nums.
     *
     * Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
     *
     * The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [12,6,1,2,7]
     * Output: 77
     * Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
     * It can be shown that there are no ordered triplets of indices with a value greater than 77.
     * Example 2:
     *
     * Input: nums = [1,10,3,4,19]
     * Output: 133
     * Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
     * It can be shown that there are no ordered triplets of indices with a value greater than 133.
     * Example 3:
     *
     * Input: nums = [1,2,3]
     * Output: 0
     * Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.
     *
     *
     * Constraints:
     *
     * 3 <= nums.length <= 100
     * 1 <= nums[i] <= 106
     * */
    public static void main(String[] args) {
        int[] nums = {12, 6, 1, 2, 7};
        System.out.println(maximumTripletValue(nums));
    }

    //Solution 1 - Using Brute Force
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static long maximumTripletValue(int[] nums) {
        long max_i = nums[0], i_minus_j = (long) -1e9, max_sum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            i_minus_j = Math.max(i_minus_j, max_i - nums[i]);
            max_i = Math.max(max_i, (long) nums[i]);
            max_sum = Math.max(max_sum, i_minus_j * nums[i + 1]);
        }

        return max_sum;
    }
}
