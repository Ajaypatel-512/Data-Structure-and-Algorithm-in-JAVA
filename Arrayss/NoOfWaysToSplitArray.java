package Arrayss;

public class NoOfWaysToSplitArray {
    /**
     * 2270. Number of Ways to Split Array
     * You are given a 0-indexed integer array nums of length n.
     *
     * nums contains a valid split at index i if the following are true:
     *
     * The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
     * There is at least one element to the right of i. That is, 0 <= i < n - 1.
     * Return the number of valid splits in nums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [10,4,-8,7]
     * Output: 2
     * Explanation:
     * There are three ways of splitting nums into two non-empty parts:
     * - Split nums at index 0. Then, the first part is [10], and its sum is 10. The second part is [4,-8,7], and its sum is 3. Since 10 >= 3, i = 0 is a valid split.
     * - Split nums at index 1. Then, the first part is [10,4], and its sum is 14. The second part is [-8,7], and its sum is -1. Since 14 >= -1, i = 1 is a valid split.
     * - Split nums at index 2. Then, the first part is [10,4,-8], and its sum is 6. The second part is [7], and its sum is 7. Since 6 < 7, i = 2 is not a valid split.
     * Thus, the number of valid splits in nums is 2.
     * Example 2:
     *
     * Input: nums = [2,3,1,0]
     * Output: 2
     * Explanation:
     * There are two valid splits in nums:
     * - Split nums at index 1. Then, the first part is [2,3], and its sum is 5. The second part is [1,0], and its sum is 1. Since 5 >= 1, i = 1 is a valid split.
     * - Split nums at index 2. Then, the first part is [2,3,1], and its sum is 6. The second part is [0], and its sum is 0. Since 6 >= 0, i = 2 is a valid split.
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 105
     * -105 <= nums[i] <= 105
     * */
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3};
        System.out.println(waysToSplitArray(nums));
    }

    //Solution 1 - Brute Force
    //Time Complexity - O(n^2)
    //Space Complexity - O(1)
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i=0; i<n-1; i++) {
            long leftSum = 0;
            long rightSum = 0;
            for (int j=0; j<=i; j++){
                leftSum += nums[i];
            }

            for (int j=i+1; j<n; j++){
                rightSum += nums[j];
            }

            if (leftSum >= rightSum){
                count += 1;
            }
        }
        return count;
    }

    //Solution 2 - Prefix Sum
    //Time Complexity - O(n)
    //Space Complexity - O(n)
    public static int waysToSplitArray2(int[] nums) {
        int n = nums.length;

        // Calculate cumulative sum
        long[] cumSum = new long[n];
        cumSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            cumSum[i] = cumSum[i - 1] + nums[i];
        }

        int split = 0;

        // Iterate and check conditions
        for (int i = 0; i < n - 1; i++) {
            long leftSum = cumSum[i];
            long rightSum = cumSum[n - 1] - cumSum[i];

            if (leftSum >= rightSum) {
                split++;
            }
        }

        return split;
    }

    //Solution 3 - Prefix Sum
    //Time Complexity - O(n)
    //Space Complexity - O(1)
    public static int waysToSplitArray3(int[] nums) {
        int n = nums.length;

        // Calculate the total sum of the array
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long leftSum = 0;
        long rightSum = 0;
        int split = 0;

        // Iterate through the array to calculate leftSum and rightSum
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;

            if (leftSum >= rightSum) {
                split++;
            }
        }

        return split;
    }


}
