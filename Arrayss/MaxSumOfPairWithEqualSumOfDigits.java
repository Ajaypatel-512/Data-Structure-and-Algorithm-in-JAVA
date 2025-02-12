package Arrayss;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfPairWithEqualSumOfDigits {
    /**
     * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
     *
     * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [18,43,36,13,7]
     * Output: 54
     * Explanation: The pairs (i, j) that satisfy the conditions are:
     * - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
     * - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
     * So the maximum sum that we can obtain is 54.
     * Example 2:
     *
     * Input: nums = [10,12,19,14]
     * Output: -1
     * Explanation: There are no two numbers that satisfy the conditions, so we return -1.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 109
     * */
    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7};
        System.out.println(maximumSum(nums));
    }

    //Solution 1 : Brute Force
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public static int maximumSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        for(int i=0; i<n; i++){
            sum[i] = getSum(nums[i]);
        }
        int max = -1;

        for (int i=0; i<n; i++){
            for (int j=i+1; j<n; j++){
                if(sum[i] == sum[j]){
                    max = Math.max(max, nums[i] + nums[j]);
                }
            }
        }
        return max;
    }

    private static int getSum(int num) {
        int sum=0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }


    //Solution 2 : Better Approach
    //Time Complexity: O(n*k) where k is the number of digits in the maximum number in the array
    //Space Complexity: O(n)
    public static int maximumSum2(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;

        for(int i=0; i<n; i++){
            int digitSum = getSum(nums[i]);
            if (map.containsKey(digitSum)) {
                result = Math.max(result, map.get(digitSum) + nums[i]);
            }
            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), nums[i]));
        }
        return result;
    }
}
