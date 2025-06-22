package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    /**
     * 90. Subsets II
     * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
     *
     * The solution set must not contain duplicate subsets. Return the solution in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [[],[0]]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * */
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> result = subsetsII.subsetsWithDup(nums);
        System.out.println(result); // Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }

    //Solution 1: Using Backtracking
    // Time Complexity: O(2^N) where N is the size of the array
    // Space Complexity: O(N) for the recursion stack
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());  // empty set

        int cachedSize = 0, startIdx = 0;
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> newResult = new ArrayList<>();  // used for new lists
            // set startIdx first before we update cachedSize
            startIdx = (i > 0 && nums[i - 1] == nums[i]) ? cachedSize : 0; // if duplicate occurs
            cachedSize = result.size(); // cache the size for startIdx in the next round
            for (int j = startIdx; j < result.size(); ++j) {
                List<Integer> L = result.get(j);
                L = new ArrayList<>(L);  // copy
                L.add(nums[i]);
                newResult.add(L);
            }
            result.addAll(newResult);  // concatenate
        }
        return result;
    }
}
