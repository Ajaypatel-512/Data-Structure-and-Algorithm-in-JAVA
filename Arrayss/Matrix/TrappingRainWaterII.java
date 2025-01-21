package Arrayss.Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {
    /**
     * 407. Trapping Rain Water II
     * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
     * Output: 4
     * Explanation: After the rain, water is trapped between the blocks.
     * We have two small ponds 1 and 3 units trapped.
     * The total volume of water trapped is 4.
     * Example 2:
     *
     *
     * Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
     * Output: 10
     *
     *
     * Constraints:
     *
     * m == heightMap.length
     * n == heightMap[i].length
     * 1 <= m, n <= 200
     * 0 <= heightMap[i][j] <= 2 * 104
     * */
    public static void main(String[] args) {

    }

    //Approach (Using Heap - See video for full intuition and thought process)
    //T.C : O(m*n log(m*n))
    //S.C : O(m*n)
    public  static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        // Min-heap to store {height, {i, j}}
        PriorityQueue<int[]> boundaryCells = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[m][n];

        // Add boundary cells (left-most, right-most, top-most, bottom-most)
        for (int row = 0; row < m; row++) {
            boundaryCells.offer(new int[]{heightMap[row][0], row, 0});
            visited[row][0] = true;
            boundaryCells.offer(new int[]{heightMap[row][n - 1], row, n - 1});
            visited[row][n - 1] = true;
        }

        for (int col = 0; col < n; col++) {
            boundaryCells.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col] = true;
            boundaryCells.offer(new int[]{heightMap[m - 1][col], m - 1, col});
            visited[m - 1][col] = true;
        }

        int water = 0;
        // Directions for moving to neighbors (left, right, up, down)
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // Process the boundary cells in the min-heap
        while (!boundaryCells.isEmpty()) {
            int[] cell = boundaryCells.poll();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];

            // Check all 4 neighbors
            for (int[] dir : directions) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                    water += Math.max(height - heightMap[i_][j_], 0);
                    boundaryCells.offer(new int[]{Math.max(height, heightMap[i_][j_]), i_, j_});
                    visited[i_][j_] = true;
                }
            }
        }

        return water;
    }
}