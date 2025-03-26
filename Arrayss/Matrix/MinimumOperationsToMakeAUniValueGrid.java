package Arrayss.Matrix;

import java.util.Arrays;

public class MinimumOperationsToMakeAUniValueGrid {
    /**
     * 2033. Minimum Operations to Make a Uni-Value Grid
     * You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.
     *
     * A uni-value grid is a grid where all the elements of it are equal.
     *
     * Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[2,4],[6,8]], x = 2
     * Output: 4
     * Explanation: We can make every element equal to 4 by doing the following:
     * - Add x to 2 once.
     * - Subtract x from 6 once.
     * - Subtract x from 8 twice.
     * A total of 4 operations were used.
     * Example 2:
     *
     *
     * Input: grid = [[1,5],[2,3]], x = 1
     * Output: 5
     * Explanation: We can make every element equal to 3.
     * Example 3:
     *
     *
     * Input: grid = [[1,2],[3,4]], x = 2
     * Output: -1
     * Explanation: It is impossible to make every element equal.
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 105
     * 1 <= m * n <= 105
     * 1 <= x, grid[i][j] <= 104
     * */
    public static void main(String[] args) {
        int[][] grid = {{2,4},{6,8}};
        int x = 2;
        System.out.println(minOperations(grid, x)); // 4
    }

    //Solution 1 : Brute Force
    //Time Complexity: O(m * n * (m * n) * log(m * n))
    //Space Complexity: O(m * n)
    public static int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        int k = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[k++] = num;
            }
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m * n; i++) {
            int target = arr[i];
            int ops = 0;
            for (int j = 0; j < m * n; j++) {
                int diff = Math.abs(arr[j] - target);
                if (diff % x != 0) {
                    ops = -1;
                    break;
                }
                ops += diff / x;
            }
            if (ops != -1) {
                res = Math.min(res, ops);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    //Solution 2 : Optimal
    //Time Complexity: O(m * n * log(m * n))
    //Space Complexity: O(m * n)
    public static int minOperations2(int[][] grid, int x) {
        int cnt=0;

        int[] arr = new int[grid[0].length* grid.length];
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }
        int k=arr.length;
        int l=0;
        int ans=0;
        Arrays.sort(arr);
        int median = arr[arr.length / 2];
        for (int i=0;i<arr.length;i++) {
            int diff = Math.abs(arr[i] - median);

            if (diff % x != 0) {
                return -1;
            }

            cnt+=diff / x;
            System.out.println(cnt);


        }
        return cnt;
    }
}
