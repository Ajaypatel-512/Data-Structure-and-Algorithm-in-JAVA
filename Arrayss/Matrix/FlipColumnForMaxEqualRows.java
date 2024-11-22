package Arrayss.Matrix;

import java.util.HashMap;

public class FlipColumnForMaxEqualRows {

    /**
     * 1072. Flip Columns For Maximum Number of Equal Rows
     *
     * You are given an m x n binary matrix matrix.
     *
     * You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).
     *
     * Return the maximum number of rows that have all values equal after some number of flips.
     *
     *
     *
     * Example 1:
     *
     * Input: matrix = [[0,1],[1,1]]
     * Output: 1
     * Explanation: After flipping no values, 1 row has all values equal.
     * Example 2:
     *
     * Input: matrix = [[0,1],[1,0]]
     * Output: 2
     * Explanation: After flipping values in the first column, both rows have equal values.
     * Example 3:
     *
     * Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
     * Output: 2
     * Explanation: After flipping values in the first two columns, the last two rows have equal values.
     *
     *
     * Constraints:
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] is either 0 or 1.
     * */

    public static void main(String[] args) {
        int[][] matrix = {{0,1},{1,1}};
        System.out.println(maxEqualRowsAfterFlips2(matrix));
    }
    private static int maxi = 0;

    //Solution 1 Using Brute Force
    //T.C : O(2^m * n * m)
    //S.C : O(n * m)
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        solve(0, matrix);
        return maxi;
    }

    private static void solve(int c, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (c >= m) return;

        solve(c + 1, matrix);

        for (int i = 0; i < n; i++) {
            matrix[i][c] = 1 - matrix[i][c];
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != matrix[i][j - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        }

        maxi = Math.max(maxi, cnt);
        solve(c + 1, matrix);
    }


    //Solution 2 Using Optimized Approach
    //T.C : O(n * m)
    //S.C : O(n * m)
    public static int maxEqualRowsAfterFlips2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < m; j++) {
                temp.append(row[j] == row[0] ? '1' : '0');
            }
            String pattern = temp.toString();
            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
        }

        int maxi = 0;
        for (int count : map.values()) {
            maxi = Math.max(maxi, count);
        }

        return maxi;
    }

}
