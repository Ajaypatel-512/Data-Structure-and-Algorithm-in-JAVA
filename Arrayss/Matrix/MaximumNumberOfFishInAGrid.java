package Arrayss.Matrix;

public class MaximumNumberOfFishInAGrid {
    /**
     * 2658. Maximum Number of Fish in a Grid
     * You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
     *
     * A land cell if grid[r][c] = 0, or
     * A water cell containing grid[r][c] fish, if grid[r][c] > 0.
     * A fisher can start at any water cell (r, c) and can do the following operations any number of times:
     *
     * Catch all the fish at cell (r, c), or
     * Move to any adjacent water cell.
     * Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.
     *
     * An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
     * Output: 7
     * Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and collect 4 fish.
     * Example 2:
     *
     *
     * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
     * Output: 1
     * Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish.
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 10
     * 0 <= grid[i][j] <= 10
     * */
    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(findMaxFish(grid));
    }

    //Solution 1 : DFS
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    static int rows;
    static int cols;
    public static int findMaxFish(int[][] grid) {
        int maxFish = 0;
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] > 0) {
                    maxFish = Math.max(maxFish, dfs(grid, i, j));
                }
            }
        }
        return maxFish;
    }

    private static int dfs(int[][] grid, int r, int c) {
        if(r<0 || r>=rows || c<0 || c>= cols || grid[r][c] == 0){
            return 0;
        }
        int ans = grid[r][c];
        grid[r][c] = 0;
        ans += dfs(grid,r-1,c) + dfs(grid,r,c+1) + dfs(grid,r+1,c) + dfs(grid,r,c-1);
        return ans;
    }
}
