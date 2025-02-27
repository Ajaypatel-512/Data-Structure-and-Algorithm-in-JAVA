package Arrayss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    /**
     * 873. Length of Longest Fibonacci Subsequence
     * A sequence x1, x2, ..., xn is Fibonacci-like if:
     *
     * n >= 3
     * xi + xi+1 == xi+2 for all i + 2 <= n
     * Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.
     *
     * A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [1,2,3,4,5,6,7,8]
     * Output: 5
     * Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
     * Example 2:
     *
     * Input: arr = [1,3,7,11,12,14,18]
     * Output: 3
     * Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
     *
     *
     * Constraints:
     *
     * 3 <= arr.length <= 1000
     * 1 <= arr[i] < arr[i + 1] <= 109
     *  */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(arr));
    }

    //Solution 1 : Using DP
    //Time Complexity: O(n^2)
    //Space Complexity: O(n^2)
    public static int lenLongestFibSubseq(int[] arr) {
        final int n = arr.length;
        int ans = 0;
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, 2));
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < n; ++i)
            numToIndex.put(arr[i], i);

        for (int j = 0; j < n; ++j)
            for (int k = j + 1; k < n; ++k) {
                final int ai = arr[k] - arr[j];
                if (ai < arr[j] && numToIndex.containsKey(ai)) {
                    final int i = numToIndex.get(ai);
                    dp[j][k] = dp[i][j] + 1;
                    ans = Math.max(ans, dp[j][k]);
                }
            }

        return ans;
    }

}
