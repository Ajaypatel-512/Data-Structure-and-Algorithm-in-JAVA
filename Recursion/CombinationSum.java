package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /**
     * 39. Combination Sum
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     *
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     *
     * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     *
     *
     *
     * Example 1:
     *
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     *
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Example 3:
     *
     * Input: candidates = [2], target = 1
     * Output: []
     *
     *
     * Constraints:
     *
     * 1 <= candidates.length <= 30
     * 2 <= candidates[i] <= 40
     * All elements of candidates are distinct.
     * 1 <= target <= 40
     * */
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }

    //Solution 1: Using Backtracking
    // Time Complexity: O(2^n) where n is the number of candidates
    // Space Complexity: O(n) for the recursion stack and the list to store combinations
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(0,target, candidates, list, ans);
        return ans;
    }

    private static void solve(int idx, int target, int[] candidates, List<Integer> list, List<List<Integer>> ans) {
        if (idx < candidates.length){
            if (target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if (candidates[idx] <= target) {
            list.add(candidates[idx]);
            solve(idx, target - candidates[idx], candidates, list, ans); // include the current candidate
            list.remove(list.size() - 1); // backtrack
        }

        solve(idx + 1, target, candidates, list, ans); // exclude the current candidate
    }

}
