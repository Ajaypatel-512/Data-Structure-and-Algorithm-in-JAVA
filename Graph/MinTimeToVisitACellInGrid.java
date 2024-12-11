package Graph;

import java.util.PriorityQueue;

public class MinTimeToVisitACellInGrid {

    /**
     * 2577. Minimum Time to Visit a Cell In a Grid
     *
     * You are given a m x n matrix grid consisting of non-negative integers where grid[row][col] represents the minimum time required to be able to visit the cell (row, col), which means you can visit the cell (row, col) only when the time you visit it is greater than or equal to grid[row][col].
     *
     * You are standing in the top-left cell of the matrix in the 0th second, and you must move to any adjacent cell in the four directions: up, down, left, and right. Each move you make takes 1 second.
     *
     * Return the minimum time required in which you can visit the bottom-right cell of the matrix. If you cannot visit the bottom-right cell, then return -1.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
     * Output: 7
     * Explanation: One of the paths that we can take is the following:
     * - at t = 0, we are on the cell (0,0).
     * - at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <= 1.
     * - at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <= 2.
     * - at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <= 3.
     * - at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <= 4.
     * - at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <= 5.
     * - at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <= 6.
     * - at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <= 7.
     * The final time is 7. It can be shown that it is the minimum time possible.
     * Example 2:
     *
     *
     *
     * Input: grid = [[0,2,4],[3,2,1],[1,0,4]]
     * Output: -1
     * Explanation: There is no path from the top left to the bottom-right cell.
     *
     *
     * Constraints:
     *
     * m == grid.length
     * n == grid[i].length
     * 2 <= m, n <= 1000
     * 4 <= m * n <= 105
     * 0 <= grid[i][j] <= 105
     * grid[0][0] == 0
     *
     * */

    public static void main(String[] args) {
        int[][] grid = {{0,1,3,2},{5,1,2,5},{4,3,8,6}};
        System.out.println(minimumTime(grid));
    }

    //Solution 1 Using Dijkstra Algorithm
    //T.C : O(m*n log(m*n))
    //S.C : O(m*n)

    private static final int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    public static int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1){
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid[0][0],0,0});
        result[0][0] = 0;

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == m-1 && col == n-1){
                return result[m-1][n-1];
            }

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] dir : directions){
                int r = row+dir[0];
                int c = col+dir[1];

                if (r<0 || r>=m || c<0 || c>=n || visited[r][c]){
                    continue;
                }

                int nextTime;
                if (grid[r][c] <= time+1){
                    nextTime = time+1;
                } else if ((grid[r][c] - time) %2 == 0) {
                    nextTime = grid[r][c] + 1;
                } else {
                    nextTime = grid[r][c];
                }

                if (nextTime < result[r][c]){
                    result[r][c] = nextTime;
                    pq.offer(new int[]{nextTime,r,c});
                }
            }
        }
        return -1;
    }
}