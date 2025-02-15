package Arrayss;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowOrColumn {
    /**
     * 2661. First Completely Painted Row or Column
     * You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].
     *
     * Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].
     *
     * Return the smallest index i at which either a row or a column will be completely painted in mat.
     *
     *
     *
     * Example 1:
     *
     * image explanation for example 1
     * Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
     * Output: 2
     * Explanation: The moves are shown in order, and both the first row and second column of the matrix become fully painted at arr[2].
     * Example 2:
     *
     * image explanation for example 2
     * Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
     * Output: 3
     * Explanation: The second column becomes fully painted at arr[3].
     *
     *
     * Constraints:
     *
     * m == mat.length
     * n = mat[i].length
     * arr.length == m * n
     * 1 <= m, n <= 105
     * 1 <= m * n <= 105
     * 1 <= arr[i], mat[r][c] <= m * n
     * All the integers of arr are unique.
     * All the integers of mat are unique.
     * */
    public static void main(String[] args) {
        int[] arr = {1,3,4,2};
        int[][] mat = {{1,4},{2,3}};
        System.out.println(firstCompleteIndex(arr, mat));
    }

    private static boolean checkRowPainted(int[][] mat, int row) {
        for (int col = 0; col < mat[0].length; col++) {
            if (mat[row][col] > 0) { // not painted
                return false;
            }
        }
        return true;
    }

    private static boolean checkColPainted(int[][] mat, int col) {
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > 0) { // not painted
                return false;
            }
        }
        return true;
    }

    // Approach - 1 (Brute Force)
    // T.C : O((m*n) * s*(m+n)) , where s = arr.size() which is (m*n)
    // S.C : O(m*n)
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, int[]> mp = new HashMap<>(); // stores value to cell-coordinate [i][j]

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = mat[i][j];
                mp.put(val, new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int[] coordinates = mp.get(val);
            int row = coordinates[0], col = coordinates[1];
            mat[row][col] *= -1; // painted

            if (checkRowPainted(mat, row) || checkColPainted(mat, col)) {
                return i;
            }
        }

        return -1;
    }


    // Approach - 2 (Better Approach)
    // T.C : O(m*n)
    // S.C : O((m*n) + m + n)
    public static int firstCompleteIndex2(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            Map<Integer, int[]> mp = new HashMap<>(); // stores value to cell-coordinate [i][j]

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = mat[i][j];
                    mp.put(val, new int[]{i, j});
                }
            }

            int[] rowCountPaint = new int[m]; // [i] = how many painted in row i
            int[] colCountPaint = new int[n]; // [i] = how many painted in col i

            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                int[] coordinates = mp.get(val);
                int row = coordinates[0], col = coordinates[1];

                rowCountPaint[row]++;
                colCountPaint[col]++;

                if (rowCountPaint[row] == n || colCountPaint[col] == m) {
                    return i;
                }
            }
            return -1;
        }

    // Approach - 3 (Best Approach)
    // T.C : O(m*n)
    // S.C : O(m*n)
    public static int firstCompleteIndex3(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            Map<Integer, Integer> mp = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                mp.put(arr[i], i);
            }

            int minIndex = Integer.MAX_VALUE;

            // Check each row one by one
            for (int row = 0; row < m; row++) {
                int lastIndex = Integer.MIN_VALUE; // last index in arr when this row will be completely painted

                for (int col = 0; col < n; col++) {
                    int val = mat[row][col];
                    int idx = mp.get(val);
                    lastIndex = Math.max(lastIndex, idx);
                }

                minIndex = Math.min(minIndex, lastIndex);
            }

            // Check each column one by one
            for (int col = 0; col < n; col++) {
                int lastIndex = Integer.MIN_VALUE; // last index in arr when this col will be completely painted

                for (int row = 0; row < m; row++) {
                    int val = mat[row][col];
                    int idx = mp.get(val);
                    lastIndex = Math.max(lastIndex, idx);
                }

                minIndex = Math.min(minIndex, lastIndex);
            }

            return minIndex;
        }
}
