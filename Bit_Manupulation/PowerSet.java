package Bit_Manupulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /**
     * 78. Subsets
     * Given an integer array nums of unique elements, return all possible subsets (the power set).
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     *
     * Constraints:
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * All the numbers of nums are unique.
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    //Solution 1: Using backtracking to generate all subsets
    // Time Complexity: O(2^n), Space Complexity: O(n)
    // Space Complexity is O(n) because of the recursion stack
    private static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int i = 0;
        solve(nums,i,temp);
    }

    private static void solve(int[] nums, int i, List<Integer> temp) {
        if (i >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        solve(nums, i + 1, temp);

        temp.remove(temp.size() - 1); // Backtrack to remove the last added element
        solve(nums, i + 1, temp);
    }
}
