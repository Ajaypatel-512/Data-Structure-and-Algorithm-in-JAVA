package Arrayss;

public class KadanesAlgoMaximumSubArraySum {
    /**
     * 53. Maximum Subarray
     * Given an integer array nums, find the subarray with the largest sum, and return its sum.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     * Example 2:
     *
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     * Example 3:
     *
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     *
     *
     * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     * */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums)); // Output: 6
    }

    //Solution 1: Brute Force Approach
    //Time Complexity: O(n^3)
    // Space Complexity: O(1)
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += nums[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    //Solution 2: Better Approach
    //Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            int sum = 0;
            for (int j=i; j<n; j++){
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    //Solution 3: Optimal Approach
    //Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int maxSubArray3(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i=0; i<n; i++){
            currentSum += nums[i];

            if (currentSum > max) {
                max = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }

        }
        return max;
    }

}
