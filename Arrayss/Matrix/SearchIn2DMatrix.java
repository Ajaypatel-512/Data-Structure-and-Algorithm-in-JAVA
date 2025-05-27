package Arrayss.Matrix;

public class SearchIn2DMatrix {
    /**
     * 74. Search a 2D Matrix
     * You are given an m x n integer matrix matrix with the following two properties:
     *
     * Each row is sorted in non-decreasing order.
     * The first integer of each row is greater than the last integer of the previous row.
     * Given an integer target, return true if target is in matrix or false otherwise.
     *
     * You must write a solution in O(log(m * n)) time complexity.
     *
     * Example 1:
     *
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * Output: true
     * Example 2:
     *
     *
     * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * Output: false
     *
     *
     * Constraints:
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     * */
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target)); // Output: true
    }

    //Solution 1: Using Briute Force
    //Time Complexity: O(m * n)
    //Space Complexity: O(1)
    private static boolean searchMatrix(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //Solution 2: Using Binary Search only on specific row which contains the target
    //Time Complexity: O(log(m * n))
    //Space Complexity: O(1)
    private static boolean searchMatrixBinary(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;

        for (int i=0; i<n; i++){
            if (matrix[i][0] <= target && matrix[i][m - 1] >= target) {
                left = i * m; // Start of the row
                right = (i + 1) * m - 1; // End of the row
                break;
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / m][mid % m];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    //Solution 3: Using Binary Search on the entire matrix
    //Time Complexity: O(log(m * n))
    //Space Complexity: O(1)
    private static boolean searchMatrixBinaryFull(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / m][mid % m];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


}
