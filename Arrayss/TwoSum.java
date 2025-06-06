package Arrayss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 1. Two Sum
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     *
     *
     * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     * */
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int target = 6;
        int[] ans = twoSum(nums,target);
        System.out.println(Arrays.toString(ans));
    }

    // Solution 1: Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[] {i , j};
                }
            }
        }
        return new int[] {-1 , -1};
    }

    // Solution 2: HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int[] twoSumUsingHashMap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);

        }
        return new int[] {-1 , -1};
    }

    // Solution 3: Using Two Pointers
    // Time Complexity: O(n log n) due to sorting
    // Space Complexity: O(1)
    public static int[] twoSumUsingTwoPointer(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
