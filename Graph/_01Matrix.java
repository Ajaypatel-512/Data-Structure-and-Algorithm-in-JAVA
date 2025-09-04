package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {
    /**
     * 542. 01 Matrix
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
     *
     * The distance between two cells sharing a common edge is 1.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: [[0,0,0],[0,1,0],[0,0,0]]
     * Example 2:
     *
     *
     * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
     * Output: [[0,0,0],[0,1,0],[1,2,1]]
     *
     *
     * Constraints:
     *
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 104
     * 1 <= m * n <= 104
     * mat[i][j] is either 0 or 1.
     * There is at least one 0 in mat.
     * */
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] result = updateMatrix(mat);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static class Node {
        int row;
        int col;
        int dist;
        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    //Solution 1: Using Multi-source BFS
    //Time Complexity: O(m * n) where m is the number of rows and n is the number of columns in the matrix.
    //Space Complexity: O(m * n) for the queue and the distance matrix.
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        // Step 1: Push all 0’s into the queue
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1; // mark 0’s as visited
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        // Step 2: Multi-source BFS
        while(!q.isEmpty()) {
            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            int steps = node.dist;

            dist[row][col] = steps;

            for (int i=0; i<4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }
}
