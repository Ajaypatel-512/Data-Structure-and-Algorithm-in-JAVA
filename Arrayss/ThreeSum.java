package Arrayss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * 15. 3Sum
     *
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     * Example 2:
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     *
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     * */
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        var result = threeSum(arr);
        System.out.println(result);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n < 3) {
            return null;
        }

        Arrays.sort(nums);

        for (int i=0; i<n - 2; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int n1 = nums[i];
            int target = -n1;
            twoSum(nums, target, i + 1, n - 1,result);
        }
        return result;
    }

    private static void twoSum(int[] nums, int target, int i, int j,List<List<Integer>> result) {
        int left = i;
        int right = j;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                // We found a valid triplet
                result.add(Arrays.asList(-target, nums[left], nums[right]));

                // Move the left pointer and skip duplicates
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }

                // Move the right pointer and skip duplicates
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }

                // Move pointers inward after recording the result
                left++;
                right--;
            } else if (sum < target) {
                left++; // If sum is less than target, move the left pointer right to increase the sum
            } else {
                right--; // If sum is greater than target, move the right pointer left to decrease the sum
            }
        }
    }
}
