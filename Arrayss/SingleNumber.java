package Arrayss;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    /**
     * 136. Single Number
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * Example 1:
     *
     * Input: nums = [2,2,1]
     *
     * Output: 1
     *
     * Example 2:
     *
     * Input: nums = [4,1,2,1,2]
     *
     * Output: 4
     *
     * Example 3:
     *
     * Input: nums = [1]
     *
     * Output: 1
     *
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * Each element in the array appears twice except for one element which appears only once.
     * */
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    //Solution 1: Using XOR operation
    //Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i=0; i<n; i++){
            xor = xor^nums[i];
        }

        return xor;
    }

    //Solution 2: Using HashMap
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int singleNumberUsingMap(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    //Solution 3: Using Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int singleNumber3(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            int num = nums[i];
            int cnt = 0;

            for(int j=0; j<n; j++){
                if(nums[j] == num){
                    cnt++;
                }
            }
            if(cnt == 1){
                return num;
            }
        }
        return -1;
    }

}
