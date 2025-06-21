package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    /**
     *
     * 40. Combination Sum II
     * Given a collection of candidate numbers (candidates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sum to target.
     * Each number in candidates may only be used once in the combination.
     * * Note: The solution set must not contain duplicate combinations.
     * Example 1:
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
     * */
    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, target, candidates, list, ans);
        return ans;
    }

    private static void solve(int idx, int target, int[] candidates, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i=idx; i< candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue; // skip duplicates
            if (candidates[i] > target) break; // no need to continue if the current candidate exceeds the target
            ds.add(candidates[i]);
            solve(i + 1, target - candidates[i], candidates, ds, ans);
            ds.remove(ds.size() - 1); // backtrack
        }
    }

}
