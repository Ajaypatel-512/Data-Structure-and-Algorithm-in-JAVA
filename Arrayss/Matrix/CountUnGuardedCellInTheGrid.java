package Arrayss.Matrix;

public class CountUnGuardedCellInTheGrid {

    /**
     * 2257. Count Unguarded Cells in the Grid
     *
     * You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
     *
     * A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
     *
     * Return the number of unoccupied cells that are not guarded.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
     * Output: 7
     * Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
     * There are a total of 7 unguarded cells, so we return 7.
     * Example 2:
     *
     *
     * Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
     * Output: 4
     * Explanation: The unguarded cells are shown in green in the above diagram.
     * There are a total of 4 unguarded cells, so we return 4.
     *
     *
     * Constraints:
     *
     * 1 <= m, n <= 105
     * 2 <= m * n <= 105
     * 1 <= guards.length, walls.length <= 5 * 104
     * 2 <= guards.length + walls.length <= m * n
     * guards[i].length == walls[j].length == 2
     * 0 <= rowi, rowj < m
     * 0 <= coli, colj < n
     * All the positions in guards and walls are unique.
     *
     * */

    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0,0},{1,1},{2,3}}, walls = {{0,1},{2,2},{1,4}};
        System.out.println(countUnguarded2(m,n,guards,walls));
    }


    //Solution 1 Simulation
    //T.C : O(G*(m+n))
    //S.C : O(m*n)
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] num: guards) {
            int i = num[0];
            int j = num[1];
            grid[i][j] = 2;
        }

        for (int[] num : walls){
            int i = num[0];
            int j = num[1];
            grid[i][j] = 3;
        }

        for (int[] guard: guards){
            int i = guard[0];
            int j = guard[1];
            markGuarded(i,j,grid);
        }

        int count = 0;
        for (int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if (grid[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }

    private static void markGuarded(int r, int c, int[][] grid) {
        //UP
        for (int i = r-1; i>=0; i--){
            if (grid[i][c] == 2 || grid[i][c] == 3){
                break;
            }
            grid[i][c] = 1;
        }

        //DOWN
        for (int i = r+1; i<grid.length; i++){
            if (grid[i][c] == 2 || grid[i][c] == 3){
                break;
            }
            grid[i][c] = 1;
        }

        //LEFT
        for (int j = c-1; j>=0; j--){
            if (grid[r][j] == 2 || grid[r][j] == 3){
                break;
            }
            grid[r][j] = 1;
        }

        //RIGHT
        for (int j = c+1; j < grid[0].length; j++){
            if (grid[r][j] == 2 || grid[r][j] == 3){
                break;
            }
            grid[r][j] = 1;
        }
    }


    //Solution 2 Using DFS
    //T.C : O(m*n + G*(m+n))
    //S.C : O(m*n)
    public static int countUnguarded2(int rows, int cols, int[][] guards, int[][] walls) {
        int[][] grid = new int[rows][cols];

        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 1;
        }

        for (int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 2;
        }

        for (int[] guard : guards) {
            int guardRow = guard[0];
            int guardCol = guard[1];

            dfs(grid, guardRow - 1, guardCol, rows, cols, 1); // UP
            dfs(grid, guardRow + 1, guardCol, rows, cols, 2); // DOWN
            dfs(grid, guardRow, guardCol - 1, rows, cols, 3); // LEFT
            dfs(grid, guardRow, guardCol + 1, rows, cols, 4); // RIGHT
        }

        int unguardedCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    private static void dfs(int[][] grid, int row, int col, int rows, int cols, int direction) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 1 || grid[row][col] == 2) {
            return;
        }

        // Mark the current cell as visited by a guard's line of sight
        grid[row][col] = 3;

        // Continue the DFS in the specified direction
        if (direction == 1) { // UP
            dfs(grid, row - 1, col, rows, cols, direction);
        } else if (direction == 2) { // DOWN
            dfs(grid, row + 1, col, rows, cols, direction);
        } else if (direction == 3) { // LEFT
            dfs(grid, row, col - 1, rows, cols, direction);
        } else { // RIGHT
            dfs(grid, row, col + 1, rows, cols, direction);
        }
    }

}
