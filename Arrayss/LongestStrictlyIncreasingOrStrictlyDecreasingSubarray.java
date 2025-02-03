package Arrayss;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    /**
     * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
     * You are given an array of integers nums. Return the length of the longest
     * subarray
     *  of nums which is either
     * strictly increasing
     *  or
     * strictly decreasing
     * .
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,4,3,3,2]
     *
     * Output: 2
     *
     * Explanation:
     *
     * The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
     *
     * The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
     *
     * Hence, we return 2.
     *
     * Example 2:
     *
     * Input: nums = [3,3,3,3]
     *
     * Output: 1
     *
     * Explanation:
     *
     * The strictly increasing subarrays of nums are [3], [3], [3], and [3].
     *
     * The strictly decreasing subarrays of nums are [3], [3], [3], and [3].
     *
     * Hence, we return 1.
     *
     * Example 3:
     *
     * Input: nums = [3,2,1]
     *
     * Output: 3
     *
     * Explanation:
     *
     * The strictly increasing subarrays of nums are [3], [2], and [1].
     *
     * The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].
     *
     * Hence, we return 3.
     *
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 50
     * 1 <= nums[i] <= 50
     * */
    public static void main(String[] args) {
        int[] nums = {3,3,3};
        System.out.println(longestMonotonicSubarray(nums));
    }

    //Solution 1 : Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for(int i=0; i<n-1; i++){
            int max = 1;
            int min = 1;
            int j = i;

            while (j< n-1 && nums[j] > nums[j+1]){
                max++;
                j++;
            }

            while (j< n-1 && nums[j] < nums[j+1]){
                min++;
                j++;
            }
            ans = Math.max(ans, Math.max(max, min));
        }
        return ans;
    }

    //Solution 2 : Optimized
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int longestMonotonicSubarray2(int[] nums) {
        int n=nums.length;
        int res=1;
        int maxIncreasing=1;
        int maxDecreasing=1;

        for (int i=1;i<n;i++) {
            if (nums[i]>nums[i-1]) {
                maxIncreasing++;
                maxDecreasing=1;
            } else if (nums[i]<nums[i-1]) {
                maxDecreasing++;
                maxIncreasing=1;
            } else {
                maxIncreasing=1;
                maxDecreasing=1;
            }

            res=Math.max(res,Math.max(maxIncreasing,maxDecreasing));
        }

        return res;
    }
}
