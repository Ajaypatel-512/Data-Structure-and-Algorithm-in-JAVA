package Arrayss;

public class MaximumNoOfMovesGrid {

    /**
     * 2684. Maximum Number of Moves in a Grid
     *
     * You are given a 0-indexed m x n matrix grid consisting of positive integers.
     *
     * You can start at any cell in the first column of the matrix, and traverse the grid in the following way:
     *
     * From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
     * Return the maximum number of moves that you can perform.
     *
     * Example 1:
     *
     *
     * Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
     * Output: 3
     * Explanation: We can start at the cell (0, 0) and make the following moves:
     * - (0, 0) -> (0, 1).
     * - (0, 1) -> (1, 2).
     * - (1, 2) -> (2, 3).
     * It can be shown that it is the maximum number of moves that can be made.
     * Example 2:
     *
     *
     * Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
     * Output: 0
     * Explanation: Starting from any cell in the first column we cannot perform any moves.
     * */

    public static void main(String[] args) {
        int[][] num = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        System.out.println(maxMoves(num));
    }

    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        int maxMoves = 0;

        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0, dp));
        }
        return maxMoves;
    }

    private static int dfs(int[][] grid, int row, int col, Integer[][] dp) {
        if (col == grid[0].length - 1) {
            return 0;
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int max = 0;
        int currentValue = grid[row][col];

        if (row > 0 && col + 1 < grid[0].length && grid[row - 1][col + 1] > currentValue) {
            max = Math.max(max, 1 + dfs(grid, row - 1, col + 1, dp));
        }

        if (col + 1 < grid[0].length && grid[row][col + 1] > currentValue) {
            max = Math.max(max, 1 + dfs(grid, row, col + 1, dp));
        }

        if (row < grid.length - 1 && col + 1 < grid[0].length && grid[row + 1][col + 1] > currentValue) {
            max = Math.max(max, 1 + dfs(grid, row + 1, col + 1, dp));
        }

        dp[row][col] = max;
        return max;
    }

}
