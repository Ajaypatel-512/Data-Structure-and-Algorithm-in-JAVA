package Arrayss.Matrix;

import java.util.Arrays;

public class UniquePaths {
    /**
     * 62. Unique Paths
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     *
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: m = 3, n = 7
     * Output: 28
     * Example 2:
     *
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Down -> Down
     * 2. Down -> Down -> Right
     * 3. Down -> Right -> Down
     *
     *
     * Constraints:
     *
     * 1 <= m, n <= 100
     * */
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // Output: 28
        System.out.println(uniquePaths(3, 2)); // Output: 3
    }

    //Solution 1: Brute Force
    //Time Complexity: O(2^(m+n) because in the worst case, we can go down or right at each step)
    //Space Complexity: O(m+n)
    public static int uniquePaths(int m, int n) {
        return countPaths(0, 0, m, n);
    }

    public static int countPaths(int i, int j, int m, int n){
        if (i == n-1 && j == m-1) {
            return 1;
        }

        if (i >= n || j >= m) {
            return 0;
        } else {
            return countPaths(i + 1, j, m, n) + countPaths(i, j + 1, m, n);
        }
    }


    //Solution 2: Dynamic Programming
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public static int uniquePaths2(int m, int n) {
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return countPaths2(0, 0, m, n,dp);
    }

    public static int countPaths2(int i, int j, int m, int n,int[][] dp) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (i >= n || j >= m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Recursively count paths to the right and down
        dp[i][j] = countPaths2(i + 1, j, m, n, dp) + countPaths2(i, j + 1, m, n, dp);
        return dp[i][j];
    }

    //Solution 3: Combinatorial Approach
    //Time Complexity: O(m+n)
    //Space Complexity: O(1)
    public static int uniquePaths3(int m, int n) {
        int totalSteps = m + n - 2; // Total steps to reach the bottom-right corner
        int downSteps = n - 1; // Down steps needed
        long result = 1;

        // Calculate the number of unique paths using combinatorial formula
        for (int i = 1; i <= downSteps; i++) {
            result = result * (totalSteps - downSteps + i) / i;
        }

        return (int) result;
    }


}
