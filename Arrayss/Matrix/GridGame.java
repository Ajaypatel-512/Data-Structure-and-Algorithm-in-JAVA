package Arrayss.Matrix;

public class GridGame {
    /**
     * You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. Two robots are playing a game on this matrix.
     *
     * Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).
     *
     * At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.
     *
     * The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[2,5,4],[1,5,1]]
     * Output: 4
     * Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
     * The cells visited by the first robot are set to 0.
     * The second robot will collect 0 + 0 + 4 + 0 = 4 points.
     * Example 2:
     *
     *
     * Input: grid = [[3,3,1],[8,5,2]]
     * Output: 4
     * Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
     * The cells visited by the first robot are set to 0.
     * The second robot will collect 0 + 3 + 1 + 0 = 4 points.
     * Example 3:
     *
     *
     * Input: grid = [[1,3,1,15],[1,3,3,1]]
     * Output: 7
     * Explanation: The optimal path taken by the first robot is shown in red, and the optimal path taken by the second robot is shown in blue.
     * The cells visited by the first robot are set to 0.
     * The second robot will collect 0 + 1 + 3 + 3 + 0 = 7 points.
     *
     *
     * Constraints:
     *
     * grid.length == 2
     * n == grid[r].length
     * 1 <= n <= 5 * 104
     * 1 <= grid[r][c] <= 105
     * */
    public static void main(String[] args) {
        int[][] grid = {{2,5,4},{1,5,1}};
        System.out.println(gridGame(grid));
    }

    //Approach - (Using cumulative sum + game strategy)
    //T.C : O(col), col = total columns in the grid
    //S.C : O(1)
    public static long gridGame(int[][] grid) {
        long firstRowRemainSum = 0;
        for (int num : grid[0]) {
            firstRowRemainSum += num;
        }

        long secondRowRemainSum = 0;
        long minimizedRobot2Sum = Long.MAX_VALUE;

        for (int Robot1Col = 0; Robot1Col < grid[0].length; Robot1Col++) {
            firstRowRemainSum -= grid[0][Robot1Col];
            long bestOfRobot2 = Math.max(firstRowRemainSum, secondRowRemainSum);
            minimizedRobot2Sum = Math.min(minimizedRobot2Sum, bestOfRobot2);
            secondRowRemainSum += grid[1][Robot1Col];
        }

        return minimizedRobot2Sum;
    }
}
