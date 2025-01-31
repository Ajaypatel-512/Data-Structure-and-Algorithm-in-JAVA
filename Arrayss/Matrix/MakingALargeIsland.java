package Arrayss.Matrix;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    /**
     * 827. Making A Large Island
     * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
     * <p>
     * Return the size of the largest island in grid after applying this operation.
     * <p>
     * An island is a 4-directionally connected group of 1s.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: grid = [[1,0],[0,1]]
     * Output: 3
     * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
     * Example 2:
     * <p>
     * Input: grid = [[1,1],[1,0]]
     * Output: 4
     * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
     * Example 3:
     * <p>
     * Input: grid = [[1,1],[1,1]]
     * Output: 4
     * Explanation: Can't change any 0 to 1, only one island with area = 4.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == grid.length
     * n == grid[i].length
     * 1 <= n <= 500
     * grid[i][j] is either 0 or 1.
     */
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        System.out.println(largestIsland(grid));
    }

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        int totalCells = n * n;
        DSU dsu = new DSU(totalCells);
        int maxArea = 0;

        // Step 1: Connect all existing 1s using DSU
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int idx = i * n + j;
                    for (int[] dir : directions) {
                        int i_ = i + dir[0], j_ = j + dir[1];
                        int idx_ = i_ * n + j_;
                        if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < n && grid[i_][j_] == 1) {
                            dsu.union(idx, idx_);
                        }
                    }
                }
            }
        }

        // Step 2: Find the largest island without modification
        for (int idx = 0; idx < totalCells; idx++) {
            if (grid[idx / n][idx % n] == 1) {
                maxArea = Math.max(maxArea, dsu.getSize(idx));
            }
        }

        // Step 3: Try flipping each 0 to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueParents = new HashSet<>();
                    for (int[] dir : directions) {
                        int i_ = i + dir[0], j_ = j + dir[1];
                        int idx_ = i_ * n + j_;
                        if (i_ >= 0 && i_ < n && j_ >= 0 && j_ < n && grid[i_][j_] == 1) {
                            uniqueParents.add(dsu.find(idx_));
                        }
                    }

                    int newSize = 1; // Flip this 0 to 1
                    for (int parent : uniqueParents) {
                        newSize += dsu.getSize(parent);
                    }
                    maxArea = Math.max(maxArea, newSize);
                }
            }
        }
        return maxArea;
    }
}
