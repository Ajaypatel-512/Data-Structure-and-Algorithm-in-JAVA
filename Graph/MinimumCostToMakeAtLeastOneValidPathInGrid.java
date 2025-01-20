package Graph;

import java.util.PriorityQueue;

public class MinimumCostToMakeAtLeastOneValidPathInGrid {
    /**
     * 1368. Minimum Cost to Make at Least One Valid Path in a Grid
     * Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:
     *
     * 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
     * 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
     * 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
     * 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
     * Notice that there could be some signs on the cells of the grid that point outside the grid.
     *
     * You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.
     *
     * You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
     *
     * Return the minimum cost to make the grid have at least one valid path.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
     * Output: 3
     * Explanation: You will start at point (0, 0).
     * The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
     * The total cost = 3.
     * Example 2:
     *
     *
     * Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
     * Output: 0
     * Explanation: You can follow the path from (0, 0) to (2, 2).
     * Example 3:
     *
     *
     * Input: grid = [[1,2],[4,3]]
     * Output: 1
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * 1 <= grid[i][j] <= 4
     * */

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
        System.out.println(minCost(grid));
    }

    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m, n;

    // Approach-1 (Backtracking DFS to try all paths) - TLE
    // T.C : O(4^(m*n))
    // S.C : O(m*n)
    private static int dfs(int i, int j, int[][] grid, boolean[][] visited, int cost) {
        if (i == m - 1 && j == n - 1) { // reached destination
            return cost;
        }

        visited[i][j] = true;

        // explore
        int minCost = Integer.MAX_VALUE;
        for (int dir_i = 0; dir_i <= 3; dir_i++) {
            int i_ = i + dir[dir_i][0];
            int j_ = j + dir[dir_i][1];

            if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                int nextCost = cost + ((grid[i][j] - 1 != dir_i) ? 1 : 0);
                minCost = Math.min(minCost, dfs(i_, j_, grid, visited, nextCost));
            }
        }

        visited[i][j] = false;
        return minCost;
    }

    public static int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, grid, visited, 0); // explore all paths by backtracking
    }


    // Approach-2 (Dijkstra's Algorithm) - Accepted
    // T.C : O((m*n) * log(m*n))
    // S.C : O(m*n)
    public static int minCost2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // min-heap
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.offer(new int[]{0, 0, 0}); // {cost, i, j}
        result[0][0] = 0;

        // T.C : O(m*n * log(m*n))
        // S.C : O(m*n)
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // log(size of pq)

            int currCost = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (result[i][j] < currCost) {
                continue;
            }

            for (int dir_i = 0; dir_i <= 3; dir_i++) {
                int i_ = i + dir[dir_i][0];
                int j_ = j + dir[dir_i][1];

                if (i_ >= 0 && j_ >= 0 && i_ < m && j_ < n) {
                    int gridDir = grid[i][j];
                    int dirCost = ((gridDir - 1 != dir_i) ? 1 : 0);

                    int newCost = currCost + dirCost;

                    if (newCost < result[i_][j_]) {
                        result[i_][j_] = newCost;
                        pq.offer(new int[]{newCost, i_, j_});
                    }
                }
            }
        }
        return result[m - 1][n - 1]; // min cost to reach (m-1, n-1)
    }
}
