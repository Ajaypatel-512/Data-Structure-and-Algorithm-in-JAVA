package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    /**
     * 216. Combination Sum III
     * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
     *
     * Only numbers 1 through 9 are used.
     * Each number is used at most once.
     * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Explanation:
     * 1 + 2 + 4 = 7
     * There are no other valid combinations.
     * Example 2:
     *
     * Input: k = 3, n = 9
     * Output: [[1,2,6],[1,3,5],[2,3,4]]
     * Explanation:
     * 1 + 2 + 6 = 9
     * 1 + 3 + 5 = 9
     * 2 + 3 + 4 = 9
     * There are no other valid combinations.
     * Example 3:
     *
     * Input: k = 4, n = 1
     * Output: []
     * Explanation: There are no valid combinations.
     * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
     *
     *
     * Constraints:
     *
     * 2 <= k <= 9
     * 1 <= n <= 60
     * */
    public static void main(String[] args) {
        int k = 3, n = 7;
        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println("Combinations for k = " + k + " and n = " + n + ": " + result);

        k = 3; n = 9;
        result = combinationSum3(k, n);
        System.out.println("Combinations for k = " + k + " and n = " + n + ": " + result);

        k = 4; n = 1;
        result = combinationSum3(k, n);
        System.out.println("Combinations for k = " + k + " and n = " + n + ": " + result);
    }

    //Solution 1: Using Backtracking
    //Time Complexity: O(2^n) in the worst case, where n is the number of elements (1 to 9).
    //Space Complexity: O(k) for the recursion stack and the combination list.
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        solve(k, n, 1, combination, result);
        return result;
    }

    private static void solve(int k, int n, int i, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (combination.size() > k || n < 0 || i > 9) {
            return;
        }

        // Include the current number
        combination.add(i);
        solve(k, n - i, i + 1, combination, result);
        combination.remove(combination.size() - 1);

        // Exclude the current number
        solve(k, n, i + 1, combination, result);
    }
}
